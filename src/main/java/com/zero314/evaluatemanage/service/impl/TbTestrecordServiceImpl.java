package com.zero314.evaluatemanage.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.zero314.evaluatemanage.dao.*;
import com.zero314.evaluatemanage.entity.*;
import com.zero314.evaluatemanage.service.TbTestrecordService;
import com.zero314.evaluatemanage.util.Result;
import com.zero314.evaluatemanage.util.Page;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * 评价记录表(TbTestrecord)表服务实现类
 *
 * @author yh
 * @since 2023-04-30 23:15:46
 */
@Service("tbTestrecordService")
public class TbTestrecordServiceImpl implements TbTestrecordService {

    @Resource
    private TbTestreportDao reportDao;

    @Resource
    private TbTestrecordDao recordDao;

    @Resource
    private TbDimensionDao dimensionDao;

    @Resource
    private TbTesttypeDao typeDao;

    @Resource
    private TbTestpointDao pointDao;

    @Resource
    private TbTestselectDao selectDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Result query(Integer id) {
        return Result.data(this.recordDao.query(id));
    }

    /**
     * 分页查询
     *
     * @param tbTestrecord 筛选条件
     * @param page         页码
     * @param size         大小
     * @return 分页对象
     */
    @Override
    public Result queryPage(TbTestrecord tbTestrecord, Long page, Long size) {
        long total = this.recordDao.count(tbTestrecord);
        return Result.data(new Page<>(page, size, total, this.recordDao.queryPage(tbTestrecord, (page - 1) * size, size)));
    }

    /**
     * 列表查询
     *
     * @param tbTestrecord 筛选条件
     * @return 对象列表
     */
    @Override
    public Result queryList(TbTestrecord tbTestrecord) {
        return Result.data(this.recordDao.queryList(tbTestrecord));
    }

    /**
     * 统计总行数
     *
     * @param tbTestrecord 查询条件
     * @return 总行数
     */
    @Override
    public Result count(TbTestrecord tbTestrecord) {
        return Result.data(this.recordDao.count(tbTestrecord));
    }

    /**
     * 新增数据
     *
     * @param tbTestrecord 实例对象
     * @return 实例对象
     */
    @Override
    public Result insert(TbTestrecord tbTestrecord) {
        this.recordDao.insert(tbTestrecord);
        return Result.data(tbTestrecord);
    }

    /**
     * 提交答案
     *
     * @param list 实体列表
     * @return 新增结果
     */
    @Override
    public Result postAnswer(List<TbTestrecord> list) {
        //已经初始化的测试报告
        TbTestreport report = reportDao.query(list.get(0).getReportId());
        //建议
        StringBuffer suggestion = new StringBuffer();
        //建议
        StringBuffer bug = new StringBuffer();
        //题目得分
        list.forEach(e -> {
            e.setScore(this.selectDao.query(e.getSelectId()).getScore());
            //对应评价点
            TbTestpoint point = this.pointDao.query(e.getPointId());
            //给出建议
            if (e.getScore() < 3) {
                suggestion.append(point.getThirdsuggestion() + "\n");
            } else if (e.getScore() < 5) {
                suggestion.append(point.getSecondsuggestion() + "\n");
            } else if (e.getScore() < 9) {
                suggestion.append(point.getFirstsuggestion() + "\n");
            }
            //给出漏洞
            if (e.getScore() < 5) {
                bug.append(point.getBug() + "\n");
            }
        });
        //提交记录
        Assert.isTrue(this.recordDao.insertBatch(list) == list.size(), "提交失败");
        //数据域得分
        List<JSONObject> typeScoreList = new ArrayList<>();
        List<TbTesttype> types = typeDao.queryList(new TbTesttype());
        types.forEach(e -> {
            JSONObject typeScore = new JSONObject(new LinkedHashMap<>());
            typeScore.put("id", e.getId());
            typeScore.put("name", e.getName());
            typeScore.put("score", this.typeDao.queryScore(e.getId(), report.getId()));
            if (typeScore.getDouble("score") == null) {
                typeScore.put("score", 0);
            }
            typeScoreList.add(typeScore);
        });
        //维度得分
        List<JSONObject> dimensionScoreList = new ArrayList<>();
        List<TbDimension> dimensions = dimensionDao.queryList(new TbDimension());
        dimensions.forEach(e -> {
            JSONObject dimensionScore = new JSONObject(new LinkedHashMap<>());
            dimensionScore.put("id", e.getId());
            dimensionScore.put("name", e.getName());
            dimensionScore.put("score", this.dimensionDao.queryScore(e.getId(), report.getId()));
            if (dimensionScore.getDouble("score") == null) {
                dimensionScore.put("score", 0);
            }
            dimensionScoreList.add(dimensionScore);
        });
        //总分
        Double finalScore = this.dimensionDao.queryFinalScore(report.getId());
        //更新测试报告
        report.setFinalpoint(finalScore);
        report.setDimensionpoint(dimensionScoreList.toString());
        report.setTypepoint(typeScoreList.toString());
        report.setSuggestion(suggestion.toString());
        report.setBug(bug.toString());
        report.setEndtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        Assert.isTrue(this.reportDao.update(report) == 1, "提交失败");
        return Result.data(report);
    }

    /**
     * 批量新增
     *
     * @param list 对象列表
     * @return 对象列表
     */
    @Override
    public Result insertBatch(List<TbTestrecord> list) {
        this.recordDao.insertBatch(list);
        return Result.data(list);
    }

    /**
     * 批量新增或按主键更新
     *
     * @param list 对象列表
     * @return 对象列表
     */
    @Override
    public Result insertOrUpdateBatch(List<TbTestrecord> list) {
        this.recordDao.insertOrUpdateBatch(list);
        return Result.data(list);
    }

    /**
     * 修改数据
     *
     * @param tbTestrecord 实例对象
     * @return 对象列表
     */
    @Override
    public Result update(TbTestrecord tbTestrecord) {
        return Result.data(this.recordDao.update(tbTestrecord) == 1);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Result delete(Integer id) {
        return Result.data(this.recordDao.delete(id) == 1);
    }
}
