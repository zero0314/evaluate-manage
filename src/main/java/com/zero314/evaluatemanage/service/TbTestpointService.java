package com.zero314.evaluatemanage.service;

import com.zero314.evaluatemanage.entity.TbTestpoint;
import com.zero314.evaluatemanage.util.Result;
import java.util.List;

/**
 * 评价点表(TbTestpoint)表服务接口
 *
 * @author yh
 * @since 2023-05-01 00:49:07
 */
public interface TbTestpointService {

    /**
     * 获取所有题目
     *
     * @return Result
     */
    Result test();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Result query(Integer id);

    /**
     * 分页查询
     *
     * @param tbTestpoint 筛选条件
     * @param page      页码
     * @param size      大小
     * @return 分页对象
     */
    Result queryPage(TbTestpoint tbTestpoint, Long page,Long size);

    /**
     * 列表查询
     *
     * @param tbTestpoint 筛选条件
     * @return 对象列表
     */
    Result queryList(TbTestpoint tbTestpoint);
    
    /**
     * 统计总行数
     *
     * @param tbTestpoint 查询条件
     * @return 总行数
     */
    Result count(TbTestpoint tbTestpoint);

    /**
     * 新增数据
     *
     * @param tbTestpoint 实例对象
     * @return 影响行数
     */
     Result insert(TbTestpoint tbTestpoint);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param list List<TbTestpoint> 实例对象列表
     * @return 影响行数
     */
     Result insertBatch(List<TbTestpoint> list);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param list List<TbTestpoint> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
     Result insertOrUpdateBatch(List<TbTestpoint> list);
    
    /**
     * 修改数据
     *
     * @param tbTestpoint 实例对象
     * @return 实例对象
     */
     Result update(TbTestpoint tbTestpoint);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
     Result delete(Integer id);

}
