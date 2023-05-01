package com.zero314.evaluatemanage.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.zero314.evaluatemanage.entity.TbRole;
import com.zero314.evaluatemanage.service.TbRoleService;
import com.zero314.evaluatemanage.util.Result;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;

/**
 * 角色表(TbRole)表控制层
 *
 * @author yh
 * @since 2023-04-30 23:15:45
 */
@RestController
@RequestMapping("tbRole")
public class TbRoleController {
    /**
     * 服务对象
     */
    @Resource
    private TbRoleService tbRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @SaCheckRole("admin")
    @PostMapping("/query")
    public Result queryById(@RequestParam("id") Integer id) {
        return this.tbRoleService.query(id);
    }
    
    /**
     * 分页查询
     *
     * @param tbRole 筛选条件
     * @return 查询结果
     */
    @SaCheckRole("admin")
    @PostMapping("/queryPage/{page}/{size}")
    public Result queryPage(@RequestBody TbRole tbRole,
                            @PathVariable Long page,
                            @PathVariable Long size) {
        return this.tbRoleService.queryPage(tbRole, page, size);
    }
    
    /**
     * 列表查询
     *
     * @param tbRole 筛选条件
     * @return 查询结果
     */
    @SaCheckRole("admin")
    @PostMapping("/queryList")
    public Result queryList(@RequestBody TbRole tbRole) {
        return this.tbRoleService.queryList(tbRole);
    }
    
    /**
     * 计数
     *
     * @param tbRole 筛选条件
     * @return 计数结果
     */
    @PostMapping("/count")
    public Result count(@RequestBody TbRole tbRole) {
        return this.tbRoleService.count(tbRole);
    }

    /**
     * 新增数据
     *
     * @param tbRole 实体
     * @return 新增结果
     */
    @SaCheckRole("admin")
    @PostMapping("/insert")
    public Result insert(@RequestBody TbRole tbRole) {
        return this.tbRoleService.insert(tbRole);
    }
    
    /**
     * 批量新增数据
     *
     * @param list 实体列表
     * @return 新增结果
     */
    @SaCheckRole("admin")
    @PostMapping("/insertBatch")
    public Result insertBatch(@RequestBody List<TbRole> list) {
        return this.tbRoleService.insertBatch(list);
    }
    
    /**
     * 批量新增或按主键更新数据
     *
     * @param list 实体列表
     * @return 操作结果
     */
    @SaCheckRole("admin")
    @PostMapping("/insertOrUpdateBatch")
    public Result insertOrUpdateBatch(@RequestBody List<TbRole> list) {
        return this.tbRoleService.insertOrUpdateBatch(list);
    }

    /**
     * 编辑数据
     *
     * @param tbRole 实体
     * @return 编辑结果
     */
    @SaCheckRole("admin")
    @PostMapping("/update")
    public Result update(@RequestBody TbRole tbRole) {
        return this.tbRoleService.update(tbRole);
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
        return this.tbRoleService.delete(id);
    }

}

