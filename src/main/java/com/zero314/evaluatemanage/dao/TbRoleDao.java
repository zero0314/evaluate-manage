package com.zero314.evaluatemanage.dao;

import com.zero314.evaluatemanage.entity.TbRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 角色表(TbRole)表数据库访问层
 *
 * @author yh
 * @since 2023-04-30 23:15:45
 */
@Mapper
public interface TbRoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbRole query(Integer id);

    /**
     * 分页查询
     *
     * @param tbRole 查询条件
     * @param offset      偏移
     * @param size        大小
     * @return 对象列表
     */
    List<TbRole> queryPage(@Param("entity")TbRole tbRole, @Param("offset")Long offset, @Param("size")Long size);

    /**
     * 列表查询
     *
     * @param tbRole 查询条件
     * @return 对象列表
     */
    List<TbRole> queryList(TbRole tbRole);

    /**
     * 通过用户id查询角色名称列表
     * @param userId 用户id
     * @return List<String></>
     */
    List<String> queryRoleNameList(Integer userId);

    /**
     * 统计总行数
     *
     * @param tbRole 查询条件
     * @return 总行数
     */
    long count(TbRole tbRole);

    /**
     * 新增数据
     *
     * @param tbRole 实例对象
     * @return 影响行数
     */
    int insert(TbRole tbRole);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbRole> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbRole> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbRole> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbRole> entities);

    /**
     * 修改数据
     *
     * @param tbRole 实例对象
     * @return 影响行数
     */
    int update(TbRole tbRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int delete(Integer id);

}

