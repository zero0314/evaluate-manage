package com.zero314.evaluatemanage.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zero314.evaluatemanage.dao.TbEnterpriseDao;
import com.zero314.evaluatemanage.dao.TbTestreportDao;
import com.zero314.evaluatemanage.entity.TbEnterprise;
import com.zero314.evaluatemanage.entity.TbTestreport;
import com.zero314.evaluatemanage.service.TbTestreportService;
import com.zero314.evaluatemanage.util.Page;
import com.zero314.evaluatemanage.util.Result;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 测试报告表(TbTestreport)表服务实现类
 *
 * @author yh
 * @since 2023-04-30 23:15:46
 */
@Service("tbTestreportService")
public class TbTestreportServiceImpl implements TbTestreportService {
    @Resource
    private TbTestreportDao tbTestreportDao;

    @Resource
    private TbEnterpriseDao enterpriseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Result query(Integer id) {
        return Result.data(this.tbTestreportDao.query(id));
    }

    /**
     * 分页查询
     *
     * @param tbTestreport 筛选条件
     * @param page         页码
     * @param size         大小
     * @return 分页对象
     */
    @Override
    public Result queryPage(TbTestreport tbTestreport, Long page, Long size) {
        long total = this.tbTestreportDao.count(tbTestreport);
        return Result.data(new Page<>(page, size, total, this.tbTestreportDao.queryPage(tbTestreport, (page - 1) * size, size)));
    }

    /**
     * 列表查询
     *
     * @param tbTestreport 筛选条件
     * @return 对象列表
     */
    @Override
    public Result queryList(TbTestreport tbTestreport) {
        return Result.data(this.tbTestreportDao.queryList(tbTestreport));
    }

    /**
     * 统计总行数
     *
     * @param tbTestreport 查询条件
     * @return 总行数
     */
    @Override
    public Result count(TbTestreport tbTestreport) {
        return Result.data(this.tbTestreportDao.count(tbTestreport));
    }

    /**
     * 查询最近n次测试报告的模块分
     *
     * @param size 数量
     * @return 结果
     */
    @Override
    public Result queryHistory(Integer size) {
        List<TbTestreport> reports = this.tbTestreportDao.queryHistory(StpUtil.getLoginIdAsInt(), size);
        List<JSONObject> data = new ArrayList<>();
        reports.forEach(e -> {
            JSONObject json = new JSONObject(new LinkedHashMap<>());
            json.put("id", e.getId());
            json.put("dimensionpoint", e.getDimensionpoint());
            json.put("createtime", e.getCreatetime());
            json.put("endtime", e.getEndtime());
            data.add(json);
        });
        return Result.data(data);
    }

    /**
     * 新增数据
     *
     * @param tbTestreport 实例对象
     * @return 实例对象
     */
    @Override
    public Result insert(TbTestreport tbTestreport) {
        this.tbTestreportDao.insert(tbTestreport);
        return Result.data(tbTestreport);
    }

    /**
     * 初始化测试报告
     *
     * @return 新增结果
     */
    @Override
    public Result init() {
        TbTestreport testreport = new TbTestreport(null, null, null, null, null, null, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), null, StpUtil.getLoginIdAsInt());
        Assert.isTrue(this.tbTestreportDao.insert(testreport) == 1, "初始化失败");
        return Result.data(testreport.getId());
    }

    /**
     * 批量新增
     *
     * @param list 对象列表
     * @return 对象列表
     */
    @Override
    public Result insertBatch(List<TbTestreport> list) {
        this.tbTestreportDao.insertBatch(list);
        return Result.data(list);
    }

    /**
     * 批量新增或按主键更新
     *
     * @param list 对象列表
     * @return 对象列表
     */
    @Override
    public Result insertOrUpdateBatch(List<TbTestreport> list) {
        this.tbTestreportDao.insertOrUpdateBatch(list);
        return Result.data(list);
    }

    /**
     * 修改数据
     *
     * @param tbTestreport 实例对象
     * @return 对象列表
     */
    @Override
    public Result update(TbTestreport tbTestreport) {
        return Result.data(this.tbTestreportDao.update(tbTestreport) == 1);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Result delete(Integer id) {
        return Result.data(this.tbTestreportDao.delete(id) == 1);
    }

    /**
     * Excel导出测试报告
     *
     * @param id 报告
     */
    @Override
    public void export(Integer id, HttpServletResponse response) {
        //企业信息
        List<TbEnterprise> enterpriseList = enterpriseDao.queryList(new TbEnterprise(null, null, null, null, null, null, null, null, StpUtil.getLoginIdAsInt()));
        TbEnterprise enterprise = enterpriseList.get(0);
        if (enterprise != null) {
            //测试报告信息
            TbTestreport report = tbTestreportDao.query(id);
            //创建一个Excel文件
            HSSFWorkbook excel = new HSSFWorkbook();
            //添加一个sheet
            HSSFSheet sheet = excel.createSheet("薪酬记录");
            HSSFRow row;
            HSSFCell cell;
            //第一行
            row = sheet.createRow(0);
            //第一列
            cell = row.createCell(0);
            //标识：企业名称
            cell.setCellValue("企业名称");
            //第二列
            cell = row.createCell(1);
            //值：企业名称
            cell.setCellValue(enterprise.getName());

            row = sheet.createRow(1);
            cell = row.createCell(0);
            cell.setCellValue("法人代表");
            cell = row.createCell(1);
            cell.setCellValue(enterprise.getRepresentative());

            row = sheet.createRow(2);
            cell = row.createCell(0);
            cell.setCellValue("联系电话");
            cell = row.createCell(1);
            cell.setCellValue(enterprise.getTelephone());

            row = sheet.createRow(3);
            cell = row.createCell(0);
            cell.setCellValue("企业地址");
            cell = row.createCell(1);
            cell.setCellValue(enterprise.getLocation());

            row = sheet.createRow(4);
            cell = row.createCell(0);
            cell.setCellValue("开始时间");
            cell = row.createCell(1);
            cell.setCellValue(report.getCreatetime());

            if (report.getEndtime() != null) {
                row = sheet.createRow(5);
                cell = row.createCell(0);
                cell.setCellValue("结束时间");
                cell = row.createCell(1);
                cell.setCellValue(report.getEndtime());

                row = sheet.createRow(6);
                cell = row.createCell(0);
                cell.setCellValue("总分");
                cell = row.createCell(1);
                cell.setCellValue(report.getFinalpoint());

                row = sheet.createRow(7);
                cell = row.createCell(0);
                cell.setCellValue("维度");
                cell = row.createCell(1);
                cell.setCellValue("得分");

                //遍历维度-得分
                String dimensionpoint = report.getDimensionpoint();
                JSONArray jsonArray = JSONArray.parseArray(dimensionpoint);
                int size = jsonArray.size();
                for (int i = 0; i < size; i++) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    row = sheet.createRow(7 + i + 1);
                    cell = row.createCell(0);
                    cell.setCellValue(json.getString("name"));
                    cell = row.createCell(1);
                    cell.setCellValue(json.getString("score"));
                }

                row = sheet.createRow(7 + size + 1);
                cell = row.createCell(0);
                cell.setCellValue("评价类别");
                cell = row.createCell(1);
                cell.setCellValue("得分");

                //遍历评价类别
                int index = 7 + size + 1;
                String typepoint = report.getTypepoint();
                jsonArray = JSONArray.parseArray(typepoint);
                size = jsonArray.size();
                for (int i = 0; i < size; i++) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    row = sheet.createRow(index + i + 1);
                    cell = row.createCell(0);
                    cell.setCellValue(json.getString("name"));
                    cell = row.createCell(1);
                    cell.setCellValue(json.getString("score"));
                }

                row = sheet.createRow(index + size + 1);
                cell = row.createCell(0);
                cell.setCellValue("需要改进的地方");
                cell = row.createCell(1);
                cell.setCellValue(report.getSuggestion());
            }
            //下载
            try {
                //设置响应头
                response.addHeader("Content-Disposition", "attachment;fileName=" + "Excel.xls");
                //将excel写到响应体的输出流中
                OutputStream out = response.getOutputStream();
                excel.write(out);
                excel.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
