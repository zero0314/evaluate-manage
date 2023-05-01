package com.zero314.evaluatemanage.dao;

import com.zero314.evaluatemanage.entity.TbDimension;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 评价模块表(TbDimension)表数据库访问层
 *
 * @author yh
 * @since 2023-04-30 23:15:45
 */
@Mapper
public interface TbDimensionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbDimension query(Integer id);

    /**
     * 分页查询
     *
     * @param tbDimension 查询条件
     * @param offset      偏移
     * @param size        大小
     * @return 对象列表
     */
    List<TbDimension> queryPage(@Param("entity") TbDimension tbDimension, @Param("offset") Long offset, @Param("size") Long size);

    /**
     * 列表查询
     *
     * @param tbDimension 查询条件
     * @return 对象列表
     */
    List<TbDimension> queryList(TbDimension tbDimension);

    /**
     * 统计总行数
     *
     * @param tbDimension 查询条件
     * @return 总行数
     */
    long count(TbDimension tbDimension);

    /**
     * 根据测试报告id和维度id计算维度得分
     *
     * @param dimensionId 维度id
     * @param reportId    测试报告id
     * @return Double
     */
    Double queryScore(@Param("dimensionId") Integer dimensionId, @Param("reportId") Integer reportId);

    /**
     * 根据测试报告id计算总分
     *
     * @param reportId    测试报告id
     * @return Double
     */
    Double queryFinalScore(@Param("reportId") Integer reportId);

    /**
     * 新增数据
     *
     * @param tbDimension 实例对象
     * @return 影响行数
     */
    int insert(TbDimension tbDimension);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbDimension> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbDimension> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbDimension> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbDimension> entities);

    /**
     * 修改数据
     *
     * @param tbDimension 实例对象
     * @return 影响行数
     */
    int update(TbDimension tbDimension);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int delete(Integer id);

}

