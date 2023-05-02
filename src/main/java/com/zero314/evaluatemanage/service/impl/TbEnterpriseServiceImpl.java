package com.zero314.evaluatemanage.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.zero314.evaluatemanage.entity.TbEnterprise;
import com.zero314.evaluatemanage.dao.TbEnterpriseDao;
import com.zero314.evaluatemanage.service.TbEnterpriseService;
import com.zero314.evaluatemanage.util.Result;
import com.zero314.evaluatemanage.util.Page;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * 企业表(TbEnterprise)表服务实现类
 *
 * @author yh
 * @since 2023-05-01 00:20:42
 */
@Service("tbEnterpriseService")
public class TbEnterpriseServiceImpl implements TbEnterpriseService {
    @Resource
    private TbEnterpriseDao tbEnterpriseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Result query(Integer id) {
        return Result.data(this.tbEnterpriseDao.query(id));
    }

    /**
     * 分页查询
     *
     * @param tbEnterprise 筛选条件
     * @param page         页码
     * @param size         大小
     * @return 分页对象
     */
    @Override
    public Result queryPage(TbEnterprise tbEnterprise, Long page, Long size) {
        long total = this.tbEnterpriseDao.count(tbEnterprise);
        return Result.data(new Page<>(page, size, total, this.tbEnterpriseDao.queryPage(tbEnterprise, (page - 1) * size, size)));
    }

    /**
     * 列表查询
     *
     * @param tbEnterprise 筛选条件
     * @return 对象列表
     */
    @Override
    public Result queryList(TbEnterprise tbEnterprise) {
        return Result.data(this.tbEnterpriseDao.queryList(tbEnterprise));
    }

    /**
     * 用户查询绑定企业
     *
     * @return Result
     */
    @Override
    public Result queryBind() {
        TbEnterprise enterprise = new TbEnterprise(null, null, null, null, null,null, null, null, null, StpUtil.getLoginIdAsInt());
        List<TbEnterprise> list = this.tbEnterpriseDao.queryList(enterprise);
        Assert.isTrue(list.size()==1,"未绑定企业");
        return Result.data(list.get(0));
    }

    /**
     * 统计总行数
     *
     * @param tbEnterprise 查询条件
     * @return 总行数
     */
    @Override
    public Result count(TbEnterprise tbEnterprise) {
        return Result.data(this.tbEnterpriseDao.count(tbEnterprise));
    }

    /**
     * 新增数据
     *
     * @param tbEnterprise 实例对象
     * @return 实例对象
     */
    @Override
    public Result insert(TbEnterprise tbEnterprise) {
        this.tbEnterpriseDao.insert(tbEnterprise);
        return Result.data(tbEnterprise);
    }

    /**
     * 用户绑定企业
     *
     * @param tbEnterprise 实例对象
     * @return Result
     */
    @Override
    public Result bind(TbEnterprise tbEnterprise) {
        //用户id
        int id = StpUtil.getLoginIdAsInt();
        tbEnterprise.setUserId(id);
        //插入数据库
        this.tbEnterpriseDao.insert(tbEnterprise);
        return Result.data(tbEnterprise);
    }

    /**
     * 批量新增
     *
     * @param list 对象列表
     * @return 对象列表
     */
    @Override
    public Result insertBatch(List<TbEnterprise> list) {
        this.tbEnterpriseDao.insertBatch(list);
        return Result.data(list);
    }

    /**
     * 批量新增或按主键更新
     *
     * @param list 对象列表
     * @return 对象列表
     */
    @Override
    public Result insertOrUpdateBatch(List<TbEnterprise> list) {
        this.tbEnterpriseDao.insertOrUpdateBatch(list);
        return Result.data(list);
    }

    /**
     * 修改数据
     *
     * @param tbEnterprise 实例对象
     * @return 对象列表
     */
    @Override
    public Result update(TbEnterprise tbEnterprise) {
        return Result.data(this.tbEnterpriseDao.update(tbEnterprise) == 1);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Result delete(Integer id) {
        return Result.data(this.tbEnterpriseDao.delete(id) == 1);
    }
}
