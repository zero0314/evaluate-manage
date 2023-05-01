package com.zero314.evaluatemanage.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.zero314.evaluatemanage.entity.TbTestpoint;
import com.zero314.evaluatemanage.service.TbTestpointService;
import com.zero314.evaluatemanage.util.Result;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;

/**
 * 评价点表(TbTestpoint)表控制层
 *
 * @author yh
 * @since 2023-05-01 00:49:07
 */
@RestController
@RequestMapping("tbTestpoint")
public class TbTestpointController {
    /**
     * 服务对象
     */
    @Resource
    private TbTestpointService tbTestpointService;

    /**
     * 获取所有题目
     *
     * @return Result
     */
    @SaCheckRole("user")
    @PostMapping("test")
    public Result test() {
        return this.tbTestpointService.test();
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
        return this.tbTestpointService.query(id);
    }

    /**
     * 分页查询
     *
     * @param tbTestpoint 筛选条件
     * @return 查询结果
     */
    @SaCheckRole("admin")
    @PostMapping("/queryPage/{page}/{size}")
    public Result queryPage(@RequestBody TbTestpoint tbTestpoint,
                            @PathVariable Long page,
                            @PathVariable Long size) {
        return this.tbTestpointService.queryPage(tbTestpoint, page, size);
    }

    /**
     * 列表查询
     *
     * @param tbTestpoint 筛选条件
     * @return 查询结果
     */
    @SaCheckRole("admin")
    @PostMapping("/queryList")
    public Result queryList(@RequestBody TbTestpoint tbTestpoint) {
        return this.tbTestpointService.queryList(tbTestpoint);
    }

    /**
     * 计数
     *
     * @param tbTestpoint 筛选条件
     * @return 计数结果
     */
    @SaCheckRole("admin")
    @PostMapping("/count")
    public Result count(@RequestBody TbTestpoint tbTestpoint) {
        return this.tbTestpointService.count(tbTestpoint);
    }

    /**
     * 新增数据
     *
     * @param tbTestpoint 实体
     * @return 新增结果
     */
    @SaCheckRole("admin")
    @PostMapping("/insert")
    public Result insert(@RequestBody TbTestpoint tbTestpoint) {
        return this.tbTestpointService.insert(tbTestpoint);
    }

    /**
     * 批量新增数据
     *
     * @param list 实体列表
     * @return 新增结果
     */
    @SaCheckRole("admin")
    @PostMapping("/insertBatch")
    public Result insertBatch(@RequestBody List<TbTestpoint> list) {
        return this.tbTestpointService.insertBatch(list);
    }

    /**
     * 批量新增或按主键更新数据
     *
     * @param list 实体列表
     * @return 操作结果
     */
    @SaCheckRole("admin")
    @PostMapping("/insertOrUpdateBatch")
    public Result insertOrUpdateBatch(@RequestBody List<TbTestpoint> list) {
        return this.tbTestpointService.insertOrUpdateBatch(list);
    }

    /**
     * 编辑数据
     *
     * @param tbTestpoint 实体
     * @return 编辑结果
     */
    @SaCheckRole("admin")
    @PostMapping("/update")
    public Result update(@RequestBody TbTestpoint tbTestpoint) {
        return this.tbTestpointService.update(tbTestpoint);
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
        return this.tbTestpointService.delete(id);
    }

}

