package com.zero314.evaluatemanage.dao;

import com.zero314.evaluatemanage.entity.TbTesttype;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 评价域表(TbTesttype)表数据库访问层
 *
 * @author yh
 * @since 2023-04-30 23:15:46
 */
@Mapper
public interface TbTesttypeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbTesttype query(Integer id);

    /**
     * 分页查询
     *
     * @param tbTesttype 查询条件
     * @param offset     偏移
     * @param size       大小
     * @return 对象列表
     */
    List<TbTesttype> queryPage(@Param("entity") TbTesttype tbTesttype, @Param("offset") Long offset, @Param("size") Long size);

    /**
     * 列表查询
     *
     * @param tbTesttype 查询条件
     * @return 对象列表
     */
    List<TbTesttype> queryList(TbTesttype tbTesttype);

    /**
     * 统计总行数
     *
     * @param tbTesttype 查询条件
     * @return 总行数
     */
    long count(TbTesttype tbTesttype);

    /**
     * 根据测试报告id和数据域id计算数据域得分
     *
     * @param typeId   数据域id
     * @param reportId 测试报告id
     * @return Double
     */
    Double queryScore(@Param("typeId") Integer typeId, @Param("reportId") Integer reportId);

    /**
     * 新增数据
     *
     * @param tbTesttype 实例对象
     * @return 影响行数
     */
    int insert(TbTesttype tbTesttype);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbTesttype> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbTesttype> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbTesttype> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbTesttype> entities);

    /**
     * 修改数据
     *
     * @param tbTesttype 实例对象
     * @return 影响行数
     */
    int update(TbTesttype tbTesttype);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int delete(Integer id);

}

