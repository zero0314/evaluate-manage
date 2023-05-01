package com.zero314.evaluatemanage.dao;

import com.zero314.evaluatemanage.entity.TbTestpoint;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 评价点表(TbTestpoint)表数据库访问层
 *
 * @author yh
 * @since 2023-05-01 00:49:07
 */
@Mapper
public interface TbTestpointDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbTestpoint query(Integer id);

    /**
     * 分页查询
     *
     * @param tbTestpoint 查询条件
     * @param offset      偏移
     * @param size        大小
     * @return 对象列表
     */
    List<TbTestpoint> queryPage(@Param("entity")TbTestpoint tbTestpoint, @Param("offset")Long offset, @Param("size")Long size);

    /**
     * 列表查询
     *
     * @param tbTestpoint 查询条件
     * @return 对象列表
     */
    List<TbTestpoint> queryList(TbTestpoint tbTestpoint);

    /**
     * 查询所有评价点的名称和id
     * @return List<String></>
     */
    List<TbTestpoint> queryAllIdAndName();

    /**
     * 统计总行数
     *
     * @param tbTestpoint 查询条件
     * @return 总行数
     */
    long count(TbTestpoint tbTestpoint);

    /**
     * 新增数据
     *
     * @param tbTestpoint 实例对象
     * @return 影响行数
     */
    int insert(TbTestpoint tbTestpoint);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbTestpoint> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbTestpoint> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbTestpoint> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbTestpoint> entities);

    /**
     * 修改数据
     *
     * @param tbTestpoint 实例对象
     * @return 影响行数
     */
    int update(TbTestpoint tbTestpoint);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int delete(Integer id);

}

