package com.zero314.evaluatemanage.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import com.zero314.evaluatemanage.entity.TbEnterprise;
import com.zero314.evaluatemanage.service.TbEnterpriseService;
import com.zero314.evaluatemanage.util.Result;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;

/**
 * 企业表(TbEnterprise)表控制层
 *
 * @author yh
 * @since 2023-05-01 00:20:42
 */
@RestController
@RequestMapping("tbEnterprise")
public class TbEnterpriseController {
    /**
     * 服务对象
     */
    @Resource
    private TbEnterpriseService tbEnterpriseService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @SaCheckRole("admin")
    @PostMapping("/query")
    public Result queryById(@RequestParam("id") Integer id) {
        return this.tbEnterpriseService.query(id);
    }

    /**
     * 分页查询
     *
     * @param tbEnterprise 筛选条件
     * @return 查询结果
     */
    @SaCheckRole("admin")
    @PostMapping("/queryPage/{page}/{size}")
    public Result queryPage(@RequestBody TbEnterprise tbEnterprise,
                            @PathVariable Long page,
                            @PathVariable Long size) {
        return this.tbEnterpriseService.queryPage(tbEnterprise, page, size);
    }
    
    /**
     * 列表查询
     *
     * @param tbEnterprise 筛选条件
     * @return 查询结果
     */
    @SaCheckRole("admin")
    @PostMapping("/queryList")
    public Result queryList(@RequestBody TbEnterprise tbEnterprise) {
        return this.tbEnterpriseService.queryList(tbEnterprise);
    }

    /**
     * 用户查询绑定企业
     *
     * @return Result
     */
    @SaCheckRole("user")
    @PostMapping("/queryBind")
    public Result queryBind() {
        return this.tbEnterpriseService.queryBind();
    }
    
    /**
     * 计数
     *
     * @param tbEnterprise 筛选条件
     * @return 计数结果
     */
    @SaCheckRole("admin")
    @PostMapping("/count")
    public Result count(@RequestBody TbEnterprise tbEnterprise) {
        return this.tbEnterpriseService.count(tbEnterprise);
    }

    /**
     * 新增数据
     *
     * @param tbEnterprise 实体
     * @return 新增结果
     */
    @SaCheckRole("admin")
    @PostMapping("/insert")
    public Result insert(@RequestBody TbEnterprise tbEnterprise) {
        return this.tbEnterpriseService.insert(tbEnterprise);
    }

    /**
     * 用户绑定企业
     *
     * @param tbEnterprise 实例对象
     * @return Result
     */
    @SaCheckRole("user")
    @PostMapping("/bind")
    public Result bind(@RequestBody TbEnterprise tbEnterprise) {
        return this.tbEnterpriseService.bind(tbEnterprise);
    }
    
    /**
     * 批量新增数据
     *
     * @param list 实体列表
     * @return 新增结果
     */
    @SaCheckRole("admin")
    @PostMapping("/insertBatch")
    public Result insertBatch(@RequestBody List<TbEnterprise> list) {
        return this.tbEnterpriseService.insertBatch(list);
    }
    
    /**
     * 批量新增或按主键更新数据
     *
     * @param list 实体列表
     * @return 操作结果
     */
    @SaCheckRole("admin")
    @PostMapping("/insertOrUpdateBatch")
    public Result insertOrUpdateBatch(@RequestBody List<TbEnterprise> list) {
        return this.tbEnterpriseService.insertOrUpdateBatch(list);
    }

    /**
     * 编辑数据
     *
     * @param tbEnterprise 实体
     * @return 编辑结果
     */
    @SaCheckRole("admin")
    @PostMapping("/update")
    public Result update(@RequestBody TbEnterprise tbEnterprise) {
        return this.tbEnterpriseService.update(tbEnterprise);
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
        return this.tbEnterpriseService.delete(id);
    }

}

