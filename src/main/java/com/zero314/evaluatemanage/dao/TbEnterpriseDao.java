package com.zero314.evaluatemanage.dao;

import com.zero314.evaluatemanage.entity.TbEnterprise;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 企业表(TbEnterprise)表数据库访问层
 *
 * @author yh
 * @since 2023-05-01 00:20:42
 */
@Mapper
public interface TbEnterpriseDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbEnterprise query(Integer id);

    /**
     * 分页查询
     *
     * @param tbEnterprise 查询条件
     * @param offset      偏移
     * @param size        大小
     * @return 对象列表
     */
    List<TbEnterprise> queryPage(@Param("entity")TbEnterprise tbEnterprise, @Param("offset")Long offset, @Param("size")Long size);

    /**
     * 列表查询
     *
     * @param tbEnterprise 查询条件
     * @return 对象列表
     */
    List<TbEnterprise> queryList(TbEnterprise tbEnterprise);

    /**
     * 统计总行数
     *
     * @param tbEnterprise 查询条件
     * @return 总行数
     */
    long count(TbEnterprise tbEnterprise);

    /**
     * 新增数据
     *
     * @param tbEnterprise 实例对象
     * @return 影响行数
     */
    int insert(TbEnterprise tbEnterprise);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbEnterprise> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbEnterprise> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbEnterprise> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbEnterprise> entities);

    /**
     * 修改数据
     *
     * @param tbEnterprise 实例对象
     * @return 影响行数
     */
    int update(TbEnterprise tbEnterprise);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int delete(Integer id);

}

