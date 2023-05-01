package com.zero314.evaluatemanage.service.impl;

import com.zero314.evaluatemanage.entity.TbDimension;
import com.zero314.evaluatemanage.dao.TbDimensionDao;
import com.zero314.evaluatemanage.service.TbDimensionService;
import com.zero314.evaluatemanage.util.Result;
import com.zero314.evaluatemanage.util.Page;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 评价模块表(TbDimension)表服务实现类
 *
 * @author yh
 * @since 2023-04-30 23:15:45
 */
@Service("tbDimensionService")
public class TbDimensionServiceImpl implements TbDimensionService {
    @Resource
    private TbDimensionDao tbDimensionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Result query(Integer id) {
        return Result.data(this.tbDimensionDao.query(id));
    }

    /**
     * 分页查询
     *
     * @param tbDimension 筛选条件
     * @param page      页码
     * @param size      大小
     * @return 分页对象
     */
    @Override
    public Result queryPage(TbDimension tbDimension, Long page,Long size) {
        long total = this.tbDimensionDao.count(tbDimension);
        return Result.data(new Page<>(page,size,total,this.tbDimensionDao.queryPage(tbDimension, (page-1)*size, size)));
    }
    
    /**
     * 列表查询
     *
     * @param tbDimension 筛选条件
     * @return 对象列表
     */
    @Override
    public Result queryList(TbDimension tbDimension) {
        return Result.data(this.tbDimensionDao.queryList(tbDimension));
    }
    
    /**
     * 统计总行数
     *
     * @param tbDimension 查询条件
     * @return 总行数
     */
    @Override
    public Result count(TbDimension tbDimension){
        return Result.data(this.tbDimensionDao.count(tbDimension));
    };

    /**
     * 新增数据
     *
     * @param tbDimension 实例对象
     * @return 实例对象
     */
    @Override
    public Result insert(TbDimension tbDimension) {
        this.tbDimensionDao.insert(tbDimension);
        return Result.data(tbDimension);
    }
    
    /**
     * 批量新增
     *
     * @param list 对象列表
     * @return 对象列表
     */
    @Override
    public Result insertBatch(List<TbDimension> list) {
        this.tbDimensionDao.insertBatch(list);
        return Result.data(list);
    }
    
    /**
     * 批量新增或按主键更新
     *
     * @param list 对象列表
     * @return 对象列表
     */
    @Override
    public Result insertOrUpdateBatch(List<TbDimension> list) {
        this.tbDimensionDao.insertOrUpdateBatch(list);
        return Result.data(list);
    }

    /**
     * 修改数据
     *
     * @param tbDimension 实例对象
     * @return 对象列表
     */
    @Override
    public Result update(TbDimension tbDimension) {
        return Result.data(this.tbDimensionDao.update(tbDimension) == 1);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Result delete(Integer id) {
        return Result.data(this.tbDimensionDao.delete(id) == 1);
    }
}
