package com.zero314.evaluatemanage.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson2.JSONObject;
import com.zero314.evaluatemanage.dao.TbRoleDao;
import com.zero314.evaluatemanage.dao.TbUserRoleDao;
import com.zero314.evaluatemanage.entity.TbUser;
import com.zero314.evaluatemanage.dao.TbUserDao;
import com.zero314.evaluatemanage.entity.TbUserRole;
import com.zero314.evaluatemanage.service.TbUserService;
import com.zero314.evaluatemanage.util.Result;
import com.zero314.evaluatemanage.util.Page;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * 用户表(TbUser)表服务实现类
 *
 * @author yh
 * @since 2023-04-30 23:15:46
 */
@Service("tbUserService")
public class TbUserServiceImpl implements TbUserService {
    @Resource
    private TbUserDao tbUserDao;

    @Resource
    private TbRoleDao tbRoleDao;

    @Resource
    private TbUserRoleDao tbUserRoleDao;

    /**
     * 获取个人信息
     *
     * @return Result
     */
    @Override
    public Result info() {
        return Result.data(this.tbUserDao.query(StpUtil.getLoginIdAsInt()));
    }

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return SaResult
     */
    @Override
    public Result login(String username, String password) {
        //验证
        TbUser user = new TbUser();
        user.setUsername(username);
        user.setPassword(password);
        List<TbUser> users = this.tbUserDao.queryList(user);
        Assert.isTrue(users.size() == 1, "用户名或密码错误");
        user = users.get(0);
        //登录
        StpUtil.login(user.getId());
        //角色信息
        List<String> roleNameList = this.tbRoleDao.queryRoleNameList(user.getId());
        //返回数据
        JSONObject data = new JSONObject(new LinkedHashMap<>());
        data.put("id", user.getId());
        data.put("username", user.getUsername());
        data.put("headimg", user.getHeadimg());
        data.put("role", roleNameList);
        data.put("token", StpUtil.getTokenValue());
        return Result.data(data);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Result query(Integer id) {
        return Result.data(this.tbUserDao.query(id));
    }

    /**
     * 分页查询
     *
     * @param tbUser 筛选条件
     * @param page   页码
     * @param size   大小
     * @return 分页对象
     */
    @Override
    public Result queryPage(TbUser tbUser, Long page, Long size) {
        long total = this.tbUserDao.count(tbUser);
        return Result.data(new Page<>(page, size, total, this.tbUserDao.queryPage(tbUser, (page - 1) * size, size)));
    }

    /**
     * 列表查询
     *
     * @param tbUser 筛选条件
     * @return 对象列表
     */
    @Override
    public Result queryList(TbUser tbUser) {
        return Result.data(this.tbUserDao.queryList(tbUser));
    }

    /**
     * 统计总行数
     *
     * @param tbUser 查询条件
     * @return 总行数
     */
    @Override
    public Result count(TbUser tbUser) {
        return Result.data(this.tbUserDao.count(tbUser));
    }

    ;

    /**
     * 新增
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    @Override
    public Result insert(TbUser tbUser) {
        this.tbUserDao.insert(tbUser);
        return Result.data(tbUser);
    }

    /**
     * 用户注册
     *
     * @param tbUser 实例对象
     * @return Result
     */
    @Override
    public Result signup(TbUser tbUser) {
        //新增用户
        this.tbUserDao.insert(tbUser);
        //分配角色(假设user角色的id为2)
        this.tbUserRoleDao.insert(new TbUserRole(null, tbUser.getId(), 2));
        //登录
        StpUtil.login(tbUser.getId());
        //角色信息
        List<String> roleNameList = new ArrayList<>();
        roleNameList.add("user");
        //返回数据
        JSONObject data = new JSONObject(new LinkedHashMap<>());
        data.put("id", tbUser.getId());
        data.put("username", tbUser.getUsername());
        data.put("headimg", tbUser.getHeadimg());
        data.put("role", roleNameList);
        data.put("token", StpUtil.getTokenValue());
        return Result.data(data);
    }

    /**
     * 批量新增
     *
     * @param list 对象列表
     * @return 对象列表
     */
    @Override
    public Result insertBatch(List<TbUser> list) {
        this.tbUserDao.insertBatch(list);
        return Result.data(list);
    }

    /**
     * 批量新增或按主键更新
     *
     * @param list 对象列表
     * @return 对象列表
     */
    @Override
    public Result insertOrUpdateBatch(List<TbUser> list) {
        this.tbUserDao.insertOrUpdateBatch(list);
        return Result.data(list);
    }

    /**
     * 修改数据
     *
     * @param tbUser 实例对象
     * @return 对象列表
     */
    @Override
    public Result update(TbUser tbUser) {
        return Result.data(this.tbUserDao.update(tbUser) == 1);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Result delete(Integer id) {
        return Result.data(this.tbUserDao.delete(id) == 1);
    }
}
