package com.zero314.evaluatemanage.dao;

import com.zero314.evaluatemanage.entity.TbTestselect;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 评价细则表(TbTestselect)表数据库访问层
 *
 * @author yh
 * @since 2023-04-30 23:15:46
 */
@Mapper
public interface TbTestselectDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbTestselect query(Integer id);

    /**
     * 分页查询
     *
     * @param tbTestselect 查询条件
     * @param offset       偏移
     * @param size         大小
     * @return 对象列表
     */
    List<TbTestselect> queryPage(@Param("entity") TbTestselect tbTestselect, @Param("offset") Long offset, @Param("size") Long size);

    /**
     * 列表查询
     *
     * @param tbTestselect 查询条件
     * @return 对象列表
     */
    List<TbTestselect> queryList(TbTestselect tbTestselect);

    /**
     * 通过评价点id查询所有选项id和名称
     *
     * @param pointId 评价点id
     * @return List<TbTestselect></>
     */
    List<TbTestselect> queryAllSelectIdAndNameByPointId(Integer pointId);

    /**
     * 统计总行数
     *
     * @param tbTestselect 查询条件
     * @return 总行数
     */
    long count(TbTestselect tbTestselect);

    /**
     * 新增数据
     *
     * @param tbTestselect 实例对象
     * @return 影响行数
     */
    int insert(TbTestselect tbTestselect);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbTestselect> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbTestselect> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbTestselect> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbTestselect> entities);

    /**
     * 修改数据
     *
     * @param tbTestselect 实例对象
     * @return 影响行数
     */
    int update(TbTestselect tbTestselect);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int delete(Integer id);

}

