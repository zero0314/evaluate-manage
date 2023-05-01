package com.zero314.evaluatemanage.service.impl;

import com.zero314.evaluatemanage.entity.TbTesttype;
import com.zero314.evaluatemanage.dao.TbTesttypeDao;
import com.zero314.evaluatemanage.service.TbTesttypeService;
import com.zero314.evaluatemanage.util.Result;
import com.zero314.evaluatemanage.util.Page;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 评价域表(TbTesttype)表服务实现类
 *
 * @author yh
 * @since 2023-04-30 23:15:46
 */
@Service("tbTesttypeService")
public class TbTesttypeServiceImpl implements TbTesttypeService {
    @Resource
    private TbTesttypeDao tbTesttypeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Result query(Integer id) {
        return Result.data(this.tbTesttypeDao.query(id));
    }

    /**
     * 分页查询
     *
     * @param tbTesttype 筛选条件
     * @param page      页码
     * @param size      大小
     * @return 分页对象
     */
    @Override
    public Result queryPage(TbTesttype tbTesttype, Long page,Long size) {
        long total = this.tbTesttypeDao.count(tbTesttype);
        return Result.data(new Page<>(page,size,total,this.tbTesttypeDao.queryPage(tbTesttype, (page-1)*size, size)));
    }
    
    /**
     * 列表查询
     *
     * @param tbTesttype 筛选条件
     * @return 对象列表
     */
    @Override
    public Result queryList(TbTesttype tbTesttype) {
        return Result.data(this.tbTesttypeDao.queryList(tbTesttype));
    }
    
    /**
     * 统计总行数
     *
     * @param tbTesttype 查询条件
     * @return 总行数
     */
    @Override
    public Result count(TbTesttype tbTesttype){
        return Result.data(this.tbTesttypeDao.count(tbTesttype));
    };

    /**
     * 新增数据
     *
     * @param tbTesttype 实例对象
     * @return 实例对象
     */
    @Override
    public Result insert(TbTesttype tbTesttype) {
        this.tbTesttypeDao.insert(tbTesttype);
        return Result.data(tbTesttype);
    }
    
    /**
     * 批量新增
     *
     * @param list 对象列表
     * @return 对象列表
     */
    @Override
    public Result insertBatch(List<TbTesttype> list) {
        this.tbTesttypeDao.insertBatch(list);
        return Result.data(list);
    }
    
    /**
     * 批量新增或按主键更新
     *
     * @param list 对象列表
     * @return 对象列表
     */
    @Override
    public Result insertOrUpdateBatch(List<TbTesttype> list) {
        this.tbTesttypeDao.insertOrUpdateBatch(list);
        return Result.data(list);
    }

    /**
     * 修改数据
     *
     * @param tbTesttype 实例对象
     * @return 对象列表
     */
    @Override
    public Result update(TbTesttype tbTesttype) {
        return Result.data(this.tbTesttypeDao.update(tbTesttype) == 1);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Result delete(Integer id) {
        return Result.data(this.tbTesttypeDao.delete(id) == 1);
    }
}
