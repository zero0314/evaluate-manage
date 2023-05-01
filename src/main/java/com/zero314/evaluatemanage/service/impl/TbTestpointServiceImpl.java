package com.zero314.evaluatemanage.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.zero314.evaluatemanage.entity.TbTestpoint;
import com.zero314.evaluatemanage.dao.TbTestpointDao;
import com.zero314.evaluatemanage.entity.TbTestselect;
import com.zero314.evaluatemanage.service.TbTestpointService;
import com.zero314.evaluatemanage.service.TbTestselectService;
import com.zero314.evaluatemanage.util.Result;
import com.zero314.evaluatemanage.util.Page;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * 评价点表(TbTestpoint)表服务实现类
 *
 * @author yh
 * @since 2023-05-01 00:49:07
 */
@Service("tbTestpointService")
public class TbTestpointServiceImpl implements TbTestpointService {
    @Resource
    private TbTestpointDao tbTestpointDao;

    @Resource
    private TbTestselectService tbTestselectService;

    /**
     * 获取所有题目
     *
     * @return Result
     */
    @Override
    public Result test() {
        //所有评价点的id和名称
        List<TbTestpoint> testpoints = this.tbTestpointDao.queryAllIdAndName();
        //返回数据
        List<JSONObject> data = new ArrayList<>();
        testpoints.forEach(e -> {
            JSONObject request = new JSONObject(new LinkedHashMap<>());
            request.put("requestId", e.getId());
            request.put("requestName", e.getName());
            //选项列表
            List<JSONObject> selectList = new ArrayList<>();
            List<TbTestselect> selects = this.tbTestselectService.queryAllSelectIdAndNameByPointId(e.getId());
            selects.forEach(o -> {
                JSONObject select = new JSONObject(new LinkedHashMap<>());
                select.put("selectId", o.getId());
                select.put("selectName", o.getName());
                selectList.add(select);
            });
            request.put("select", selectList);
            data.add(request);
        });
        return Result.data(data);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Result query(Integer id) {
        return Result.data(this.tbTestpointDao.query(id));
    }

    /**
     * 分页查询
     *
     * @param tbTestpoint 筛选条件
     * @param page        页码
     * @param size        大小
     * @return 分页对象
     */
    @Override
    public Result queryPage(TbTestpoint tbTestpoint, Long page, Long size) {
        long total = this.tbTestpointDao.count(tbTestpoint);
        return Result.data(new Page<>(page, size, total, this.tbTestpointDao.queryPage(tbTestpoint, (page - 1) * size, size)));
    }

    /**
     * 列表查询
     *
     * @param tbTestpoint 筛选条件
     * @return 对象列表
     */
    @Override
    public Result queryList(TbTestpoint tbTestpoint) {
        return Result.data(this.tbTestpointDao.queryList(tbTestpoint));
    }

    /**
     * 统计总行数
     *
     * @param tbTestpoint 查询条件
     * @return 总行数
     */
    @Override
    public Result count(TbTestpoint tbTestpoint) {
        return Result.data(this.tbTestpointDao.count(tbTestpoint));
    }

    ;

    /**
     * 新增数据
     *
     * @param tbTestpoint 实例对象
     * @return 实例对象
     */
    @Override
    public Result insert(TbTestpoint tbTestpoint) {
        this.tbTestpointDao.insert(tbTestpoint);
        return Result.data(tbTestpoint);
    }

    /**
     * 批量新增
     *
     * @param list 对象列表
     * @return 对象列表
     */
    @Override
    public Result insertBatch(List<TbTestpoint> list) {
        this.tbTestpointDao.insertBatch(list);
        return Result.data(list);
    }

    /**
     * 批量新增或按主键更新
     *
     * @param list 对象列表
     * @return 对象列表
     */
    @Override
    public Result insertOrUpdateBatch(List<TbTestpoint> list) {
        this.tbTestpointDao.insertOrUpdateBatch(list);
        return Result.data(list);
    }

    /**
     * 修改数据
     *
     * @param tbTestpoint 实例对象
     * @return 对象列表
     */
    @Override
    public Result update(TbTestpoint tbTestpoint) {
        return Result.data(this.tbTestpointDao.update(tbTestpoint) == 1);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Result delete(Integer id) {
        return Result.data(this.tbTestpointDao.delete(id) == 1);
    }
}
