package com.zero314.evaluatemanage.service;

import com.zero314.evaluatemanage.entity.TbEnterprise;
import com.zero314.evaluatemanage.util.Result;
import java.util.List;

/**
 * 企业表(TbEnterprise)表服务接口
 *
 * @author yh
 * @since 2023-05-01 00:20:42
 */
public interface TbEnterpriseService {

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
     * @param tbEnterprise 筛选条件
     * @param page      页码
     * @param size      大小
     * @return 分页对象
     */
    Result queryPage(TbEnterprise tbEnterprise, Long page,Long size);

    /**
     * 列表查询
     *
     * @param tbEnterprise 筛选条件
     * @return 对象列表
     */
    Result queryList(TbEnterprise tbEnterprise);

    /**
     * 用户查询绑定企业
     *
     * @return Result
     */
    Result queryBind();

    /**
     * 统计总行数
     *
     * @param tbEnterprise 查询条件
     * @return 总行数
     */
    Result count(TbEnterprise tbEnterprise);

    /**
     * 新增数据
     *
     * @param tbEnterprise 实例对象
     * @return 影响行数
     */
     Result insert(TbEnterprise tbEnterprise);

    /**
     * 用户绑定企业
     *
     * @param tbEnterprise 实例对象
     * @return Result
     */
    Result bind(TbEnterprise tbEnterprise);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param list List<TbEnterprise> 实例对象列表
     * @return 影响行数
     */
     Result insertBatch(List<TbEnterprise> list);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param list List<TbEnterprise> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
     Result insertOrUpdateBatch(List<TbEnterprise> list);
    
    /**
     * 修改数据
     *
     * @param tbEnterprise 实例对象
     * @return 实例对象
     */
     Result update(TbEnterprise tbEnterprise);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
     Result delete(Integer id);
}
