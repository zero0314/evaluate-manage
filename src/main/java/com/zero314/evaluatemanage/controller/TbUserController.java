package com.zero314.evaluatemanage.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import com.zero314.evaluatemanage.entity.TbUser;
import com.zero314.evaluatemanage.service.TbUserService;
import com.zero314.evaluatemanage.util.Result;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;

/**
 * 用户表(TbUser)表控制层
 *
 * @author yh
 * @since 2023-04-30 23:15:46
 */
@RestController
@RequestMapping("tbUser")
public class TbUserController {
    /**
     * 服务对象
     */
    @Resource
    private TbUserService tbUserService;

    /**
     * 获取个人信息
     * @return Result
     */
    @SaCheckLogin
    @PostMapping("info")
    public Result info(){
        return this.tbUserService.info();
    }

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return Result
     */
    @PostMapping("login")
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password) {
        return tbUserService.login(username, password);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @SaCheckRole("admin")
    @PostMapping("/query")
    public Result queryById(@RequestParam("id") Integer id) {
        return this.tbUserService.query(id);
    }

    /**
     * 分页查询
     *
     * @param tbUser 筛选条件
     * @return 查询结果
     */
    @SaCheckRole("admin")
    @PostMapping("/queryPage/{page}/{size}")
    public Result queryPage(@RequestBody TbUser tbUser,
                            @PathVariable Long page,
                            @PathVariable Long size) {
        return this.tbUserService.queryPage(tbUser, page, size);
    }

    /**
     * 列表查询
     *
     * @param tbUser 筛选条件
     * @return 查询结果
     */
    @SaCheckRole("admin")
    @PostMapping("/queryList")
    public Result queryList(@RequestBody TbUser tbUser) {
        return this.tbUserService.queryList(tbUser);
    }

    /**
     * 计数
     *
     * @param tbUser 筛选条件
     * @return 计数结果
     */
    @SaCheckRole("admin")
    @PostMapping("/count")
    public Result count(@RequestBody TbUser tbUser) {
        return this.tbUserService.count(tbUser);
    }

    /**
     * 新增
     *
     * @param tbUser 实体
     * @return 新增结果
     */
    @SaCheckRole("admin")
    @PostMapping("/insert")
    public Result insert(@RequestBody TbUser tbUser) {
        return this.tbUserService.insert(tbUser);
    }

    /**
     * 用户注册
     *
     * @param tbUser 实体
     * @return Result
     */
    @PostMapping("/signup")
    public Result signup(@RequestBody TbUser tbUser) {
        return this.tbUserService.signup(tbUser);
    }

    /**
     * 批量新增数据
     *
     * @param list 实体列表
     * @return 新增结果
     */
    @SaCheckRole("admin")
    @PostMapping("/insertBatch")
    public Result insertBatch(@RequestBody List<TbUser> list) {
        return this.tbUserService.insertBatch(list);
    }

    /**
     * 批量新增或按主键更新数据
     *
     * @param list 实体列表
     * @return 操作结果
     */
    @SaCheckRole("admin")
    @PostMapping("/insertOrUpdateBatch")
    public Result insertOrUpdateBatch(@RequestBody List<TbUser> list) {
        return this.tbUserService.insertOrUpdateBatch(list);
    }

    /**
     * 编辑数据
     *
     * @param tbUser 实体
     * @return 编辑结果
     */
    @SaCheckRole("admin")
    @PostMapping("/update")
    public Result update(@RequestBody TbUser tbUser) {
        return this.tbUserService.update(tbUser);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @SaCheckRole("admin")
    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        return this.tbUserService.delete(id);
    }

}

