package com.zero314.evaluatemanage.dao;

import com.zero314.evaluatemanage.entity.TbUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 用户表(TbUser)表数据库访问层
 *
 * @author yh
 * @since 2023-04-30 23:15:46
 */
@Mapper
public interface TbUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbUser query(Integer id);

    /**
     * 分页查询
     *
     * @param tbUser 查询条件
     * @param offset      偏移
     * @param size        大小
     * @return 对象列表
     */
    List<TbUser> queryPage(@Param("entity")TbUser tbUser, @Param("offset")Long offset, @Param("size")Long size);

    /**
     * 列表查询
     *
     * @param tbUser 查询条件
     * @return 对象列表
     */
    List<TbUser> queryList(TbUser tbUser);

    /**
     * 统计总行数
     *
     * @param tbUser 查询条件
     * @return 总行数
     */
    long count(TbUser tbUser);

    /**
     * 新增数据
     *
     * @param tbUser 实例对象
     * @return 影响行数
     */
    int insert(TbUser tbUser);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbUser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbUser> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbUser> entities);

    /**
     * 修改数据
     *
     * @param tbUser 实例对象
     * @return 影响行数
     */
    int update(TbUser tbUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int delete(Integer id);

}

