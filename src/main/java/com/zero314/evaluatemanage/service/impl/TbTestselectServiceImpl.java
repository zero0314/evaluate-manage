package com.zero314.evaluatemanage.service.impl;

import com.zero314.evaluatemanage.entity.TbTestselect;
import com.zero314.evaluatemanage.dao.TbTestselectDao;
import com.zero314.evaluatemanage.service.TbTestselectService;
import com.zero314.evaluatemanage.util.Result;
import com.zero314.evaluatemanage.util.Page;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 评价细则表(TbTestselect)表服务实现类
 *
 * @author yh
 * @since 2023-04-30 23:15:46
 */
@Service("tbTestselectService")
public class TbTestselectServiceImpl implements TbTestselectService {
    @Resource
    private TbTestselectDao tbTestselectDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Result query(Integer id) {
        return Result.data(this.tbTestselectDao.query(id));
    }

    /**
     * 分页查询
     *
     * @param tbTestselect 筛选条件
     * @param page      页码
     * @param size      大小
     * @return 分页对象
     */
    @Override
    public Result queryPage(TbTestselect tbTestselect, Long page,Long size) {
        long total = this.tbTestselectDao.count(tbTestselect);
        return Result.data(new Page<>(page,size,total,this.tbTestselectDao.queryPage(tbTestselect, (page-1)*size, size)));
    }
    
    /**
     * 列表查询
     *
     * @param tbTestselect 筛选条件
     * @return 对象列表
     */
    @Override
    public Result queryList(TbTestselect tbTestselect) {
        return Result.data(this.tbTestselectDao.queryList(tbTestselect));
    }

    /**
     * 通过评价点id查询所有选项名称
     *
     * @param pointId 评价点id
     * @return List<String></>
     */
    @Override
    public List<TbTestselect> queryAllSelectIdAndNameByPointId(Integer pointId){
        return this.tbTestselectDao.queryAllSelectIdAndNameByPointId(pointId);
    }

    /**
     * 统计总行数
     *
     * @param tbTestselect 查询条件
     * @return 总行数
     */
    @Override
    public Result count(TbTestselect tbTestselect){
        return Result.data(this.tbTestselectDao.count(tbTestselect));
    };

    /**
     * 新增数据
     *
     * @param tbTestselect 实例对象
     * @return 实例对象
     */
    @Override
    public Result insert(TbTestselect tbTestselect) {
        this.tbTestselectDao.insert(tbTestselect);
        return Result.data(tbTestselect);
    }
    
    /**
     * 批量新增
     *
     * @param list 对象列表
     * @return 对象列表
     */
    @Override
    public Result insertBatch(List<TbTestselect> list) {
        this.tbTestselectDao.insertBatch(list);
        return Result.data(list);
    }
    
    /**
     * 批量新增或按主键更新
     *
     * @param list 对象列表
     * @return 对象列表
     */
    @Override
    public Result insertOrUpdateBatch(List<TbTestselect> list) {
        this.tbTestselectDao.insertOrUpdateBatch(list);
        return Result.data(list);
    }

    /**
     * 修改数据
     *
     * @param tbTestselect 实例对象
     * @return 对象列表
     */
    @Override
    public Result update(TbTestselect tbTestselect) {
        return Result.data(this.tbTestselectDao.update(tbTestselect) == 1);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Result delete(Integer id) {
        return Result.data(this.tbTestselectDao.delete(id) == 1);
    }
}
