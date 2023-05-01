package com.zero314.evaluatemanage.service;

import com.zero314.evaluatemanage.entity.TbUser;
import com.zero314.evaluatemanage.util.Result;
import java.util.List;

/**
 * 用户表(TbUser)表服务接口
 *
 * @author yh
 * @since 2023-04-30 23:15:46
 */
public interface TbUserService {

    /**
     * 获取个人信息
     * @return Result
     */
    Result info();

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return Result
     */
    Result login(String username, String password);

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
     * @param tbUser 筛选条件
     * @param page      页码
     * @param size      大小
     * @return 分页对象
     */
    Result queryPage(TbUser tbUser, Long page,Long size);

    /**
     * 列表查询
     *
     * @param tbUser 筛选条件
     * @return 对象列表
     */
    Result queryList(TbUser tbUser);
    
    /**
     * 统计总行数
     *
     * @param tbUser 查询条件
     * @return 总行数
     */
    Result count(TbUser tbUser);

    /**
     * 新增数据
     *
     * @param tbUser 实例对象
     * @return 影响行数
     */
     Result insert(TbUser tbUser);

    Result signup(TbUser tbUser);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param list List<TbUser> 实例对象列表
     * @return 影响行数
     */
     Result insertBatch(List<TbUser> list);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param list List<TbUser> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
     Result insertOrUpdateBatch(List<TbUser> list);
    
    /**
     * 修改数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
     Result update(TbUser tbUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
     Result delete(Integer id);
}
