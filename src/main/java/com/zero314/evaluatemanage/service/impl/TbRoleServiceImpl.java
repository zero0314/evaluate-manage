package com.zero314.evaluatemanage.service.impl;

import com.zero314.evaluatemanage.entity.TbRole;
import com.zero314.evaluatemanage.dao.TbRoleDao;
import com.zero314.evaluatemanage.service.TbRoleService;
import com.zero314.evaluatemanage.util.Result;
import com.zero314.evaluatemanage.util.Page;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 角色表(TbRole)表服务实现类
 *
 * @author yh
 * @since 2023-04-30 23:15:45
 */
@Service("tbRoleService")
public class TbRoleServiceImpl implements TbRoleService {
    @Resource
    private TbRoleDao tbRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Result query(Integer id) {
        return Result.data(this.tbRoleDao.query(id));
    }

    /**
     * 分页查询
     *
     * @param tbRole 筛选条件
     * @param page      页码
     * @param size      大小
     * @return 分页对象
     */
    @Override
    public Result queryPage(TbRole tbRole, Long page,Long size) {
        long total = this.tbRoleDao.count(tbRole);
        return Result.data(new Page<>(page,size,total,this.tbRoleDao.queryPage(tbRole, (page-1)*size, size)));
    }
    
    /**
     * 列表查询
     *
     * @param tbRole 筛选条件
     * @return 对象列表
     */
    @Override
    public Result queryList(TbRole tbRole) {
        return Result.data(this.tbRoleDao.queryList(tbRole));
    }
    
    /**
     * 统计总行数
     *
     * @param tbRole 查询条件
     * @return 总行数
     */
    @Override
    public Result count(TbRole tbRole){
        return Result.data(this.tbRoleDao.count(tbRole));
    };

    /**
     * 新增数据
     *
     * @param tbRole 实例对象
     * @return 实例对象
     */
    @Override
    public Result insert(TbRole tbRole) {
        this.tbRoleDao.insert(tbRole);
        return Result.data(tbRole);
    }
    
    /**
     * 批量新增
     *
     * @param list 对象列表
     * @return 对象列表
     */
    @Override
    public Result insertBatch(List<TbRole> list) {
        this.tbRoleDao.insertBatch(list);
        return Result.data(list);
    }
    
    /**
     * 批量新增或按主键更新
     *
     * @param list 对象列表
     * @return 对象列表
     */
    @Override
    public Result insertOrUpdateBatch(List<TbRole> list) {
        this.tbRoleDao.insertOrUpdateBatch(list);
        return Result.data(list);
    }

    /**
     * 修改数据
     *
     * @param tbRole 实例对象
     * @return 对象列表
     */
    @Override
    public Result update(TbRole tbRole) {
        return Result.data(this.tbRoleDao.update(tbRole) == 1);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Result delete(Integer id) {
        return Result.data(this.tbRoleDao.delete(id) == 1);
    }
}
