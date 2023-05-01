package com.zero314.evaluatemanage.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.zero314.evaluatemanage.entity.TbUserRole;
import com.zero314.evaluatemanage.service.TbUserRoleService;
import com.zero314.evaluatemanage.util.Result;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;

/**
 * 用户-角色关联表(TbUserRole)表控制层
 *
 * @author yh
 * @since 2023-04-30 23:15:46
 */
@RestController
@RequestMapping("tbUserRole")
public class TbUserRoleController {
    /**
     * 服务对象
     */
    @Resource
    private TbUserRoleService tbUserRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @SaCheckRole("admin")
    @PostMapping("/query")
    public Result queryById(@RequestParam("id") Integer id) {
        return this.tbUserRoleService.query(id);
    }
    
    /**
     * 分页查询
     *
     * @param tbUserRole 筛选条件
     * @return 查询结果
     */
    @SaCheckRole("admin")
    @PostMapping("/queryPage/{page}/{size}")
    public Result queryPage(@RequestBody TbUserRole tbUserRole,
                            @PathVariable Long page,
                            @PathVariable Long size) {
        return this.tbUserRoleService.queryPage(tbUserRole, page, size);
    }
    
    /**
     * 列表查询
     *
     * @param tbUserRole 筛选条件
     * @return 查询结果
     */
    @SaCheckRole("admin")
    @PostMapping("/queryList")
    public Result queryList(@RequestBody TbUserRole tbUserRole) {
        return this.tbUserRoleService.queryList(tbUserRole);
    }
    
    /**
     * 计数
     *
     * @param tbUserRole 筛选条件
     * @return 计数结果
     */
    @SaCheckRole("admin")
    @PostMapping("/count")
    public Result count(@RequestBody TbUserRole tbUserRole) {
        return this.tbUserRoleService.count(tbUserRole);
    }

    /**
     * 新增数据
     *
     * @param tbUserRole 实体
     * @return 新增结果
     */
    @SaCheckRole("admin")
    @PostMapping("/insert")
    public Result insert(@RequestBody TbUserRole tbUserRole) {
        return this.tbUserRoleService.insert(tbUserRole);
    }
    
    /**
     * 批量新增数据
     *
     * @param list 实体列表
     * @return 新增结果
     */
    @SaCheckRole("admin")
    @PostMapping("/insertBatch")
    public Result insertBatch(@RequestBody List<TbUserRole> list) {
        return this.tbUserRoleService.insertBatch(list);
    }
    
    /**
     * 批量新增或按主键更新数据
     *
     * @param list 实体列表
     * @return 操作结果
     */
    @SaCheckRole("admin")
    @PostMapping("/insertOrUpdateBatch")
    public Result insertOrUpdateBatch(@RequestBody List<TbUserRole> list) {
        return this.tbUserRoleService.insertOrUpdateBatch(list);
    }

    /**
     * 编辑数据
     *
     * @param tbUserRole 实体
     * @return 编辑结果
     */
    @SaCheckRole("admin")
    @PostMapping("/update")
    public Result update(@RequestBody TbUserRole tbUserRole) {
        return this.tbUserRoleService.update(tbUserRole);
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
        return this.tbUserRoleService.delete(id);
    }

}

