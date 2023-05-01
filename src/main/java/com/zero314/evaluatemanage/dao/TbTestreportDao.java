package com.zero314.evaluatemanage.dao;

import com.zero314.evaluatemanage.entity.TbTestreport;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 测试报告表(TbTestreport)表数据库访问层
 *
 * @author yh
 * @since 2023-04-30 23:15:46
 */
@Mapper
public interface TbTestreportDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbTestreport query(Integer id);

    /**
     * 分页查询
     *
     * @param tbTestreport 查询条件
     * @param offset       偏移
     * @param size         大小
     * @return 对象列表
     */
    List<TbTestreport> queryPage(@Param("entity") TbTestreport tbTestreport, @Param("offset") Long offset, @Param("size") Long size);

    /**
     * 列表查询
     *
     * @param tbTestreport 查询条件
     * @return 对象列表
     */
    List<TbTestreport> queryList(TbTestreport tbTestreport);

    /**
     * 统计总行数
     *
     * @param tbTestreport 查询条件
     * @return 总行数
     */
    long count(TbTestreport tbTestreport);

    /**
     * 根据用户id查询最近n次测试报告的模块分
     *
     * @param userId 用户id
     * @param size   数量
     * @return 结果
     */
    List<TbTestreport> queryHistory(@Param("userId") Integer userId, @Param("size") Integer size);

    /**
     * 新增数据
     *
     * @param tbTestreport 实例对象
     * @return 影响行数
     */
    int insert(TbTestreport tbTestreport);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbTestreport> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbTestreport> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbTestreport> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbTestreport> entities);

    /**
     * 修改数据
     *
     * @param tbTestreport 实例对象
     * @return 影响行数
     */
    int update(TbTestreport tbTestreport);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int delete(Integer id);

}

