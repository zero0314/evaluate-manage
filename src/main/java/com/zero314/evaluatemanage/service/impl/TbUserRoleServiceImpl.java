package com.zero314.evaluatemanage.service.impl;

import com.zero314.evaluatemanage.entity.TbUserRole;
import com.zero314.evaluatemanage.dao.TbUserRoleDao;
import com.zero314.evaluatemanage.service.TbUserRoleService;
import com.zero314.evaluatemanage.util.Result;
import com.zero314.evaluatemanage.util.Page;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 用户-角色关联表(TbUserRole)表服务实现类
 *
 * @author yh
 * @since 2023-04-30 23:15:46
 */
@Service("tbUserRoleService")
public class TbUserRoleServiceImpl implements TbUserRoleService {
    @Resource
    private TbUserRoleDao tbUserRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Result query(Integer id) {
        return Result.data(this.tbUserRoleDao.query(id));
    }

    /**
     * 分页查询
     *
     * @param tbUserRole 筛选条件
     * @param page      页码
     * @param size      大小
     * @return 分页对象
     */
    @Override
    public Result queryPage(TbUserRole tbUserRole, Long page,Long size) {
        long total = this.tbUserRoleDao.count(tbUserRole);
        return Result.data(new Page<>(page,size,total,this.tbUserRoleDao.queryPage(tbUserRole, (page-1)*size, size)));
    }
    
    /**
     * 列表查询
     *
     * @param tbUserRole 筛选条件
     * @return 对象列表
     */
    @Override
    public Result queryList(TbUserRole tbUserRole) {
        return Result.data(this.tbUserRoleDao.queryList(tbUserRole));
    }
    
    /**
     * 统计总行数
     *
     * @param tbUserRole 查询条件
     * @return 总行数
     */
    @Override
    public Result count(TbUserRole tbUserRole){
        return Result.data(this.tbUserRoleDao.count(tbUserRole));
    };

    /**
     * 新增数据
     *
     * @param tbUserRole 实例对象
     * @return 实例对象
     */
    @Override
    public Result insert(TbUserRole tbUserRole) {
        this.tbUserRoleDao.insert(tbUserRole);
        return Result.data(tbUserRole);
    }
    
    /**
     * 批量新增
     *
     * @param list 对象列表
     * @return 对象列表
     */
    @Override
    public Result insertBatch(List<TbUserRole> list) {
        this.tbUserRoleDao.insertBatch(list);
        return Result.data(list);
    }
    
    /**
     * 批量新增或按主键更新
     *
     * @param list 对象列表
     * @return 对象列表
     */
    @Override
    public Result insertOrUpdateBatch(List<TbUserRole> list) {
        this.tbUserRoleDao.insertOrUpdateBatch(list);
        return Result.data(list);
    }

    /**
     * 修改数据
     *
     * @param tbUserRole 实例对象
     * @return 对象列表
     */
    @Override
    public Result update(TbUserRole tbUserRole) {
        return Result.data(this.tbUserRoleDao.update(tbUserRole) == 1);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Result delete(Integer id) {
        return Result.data(this.tbUserRoleDao.delete(id) == 1);
    }
}
