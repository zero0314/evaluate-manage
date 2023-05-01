package com.zero314.evaluatemanage.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.zero314.evaluatemanage.entity.TbTesttype;
import com.zero314.evaluatemanage.service.TbTesttypeService;
import com.zero314.evaluatemanage.util.Result;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;

/**
 * 评价域表(TbTesttype)表控制层
 *
 * @author yh
 * @since 2023-04-30 23:15:46
 */
@RestController
@RequestMapping("tbTesttype")
public class TbTesttypeController {
    /**
     * 服务对象
     */
    @Resource
    private TbTesttypeService tbTesttypeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @SaCheckRole("admin")
    @PostMapping("/query")
    public Result queryById(@RequestParam("id") Integer id) {
        return this.tbTesttypeService.query(id);
    }
    
    /**
     * 分页查询
     *
     * @param tbTesttype 筛选条件
     * @return 查询结果
     */
    @SaCheckRole("admin")
    @PostMapping("/queryPage/{page}/{size}")
    public Result queryPage(@RequestBody TbTesttype tbTesttype,
                            @PathVariable Long page,
                            @PathVariable Long size) {
        return this.tbTesttypeService.queryPage(tbTesttype, page, size);
    }
    
    /**
     * 列表查询
     *
     * @param tbTesttype 筛选条件
     * @return 查询结果
     */
    @SaCheckRole("admin")
    @PostMapping("/queryList")
    public Result queryList(@RequestBody TbTesttype tbTesttype) {
        return this.tbTesttypeService.queryList(tbTesttype);
    }
    
    /**
     * 计数
     *
     * @param tbTesttype 筛选条件
     * @return 计数结果
     */
    @SaCheckRole("admin")
    @PostMapping("/count")
    public Result count(@RequestBody TbTesttype tbTesttype) {
        return this.tbTesttypeService.count(tbTesttype);
    }

    /**
     * 新增数据
     *
     * @param tbTesttype 实体
     * @return 新增结果
     */
    @SaCheckRole("admin")
    @PostMapping("/insert")
    public Result insert(@RequestBody TbTesttype tbTesttype) {
        return this.tbTesttypeService.insert(tbTesttype);
    }
    
    /**
     * 批量新增数据
     *
     * @param list 实体列表
     * @return 新增结果
     */
    @SaCheckRole("admin")
    @PostMapping("/insertBatch")
    public Result insertBatch(@RequestBody List<TbTesttype> list) {
        return this.tbTesttypeService.insertBatch(list);
    }
    
    /**
     * 批量新增或按主键更新数据
     *
     * @param list 实体列表
     * @return 操作结果
     */
    @SaCheckRole("admin")
    @PostMapping("/insertOrUpdateBatch")
    public Result insertOrUpdateBatch(@RequestBody List<TbTesttype> list) {
        return this.tbTesttypeService.insertOrUpdateBatch(list);
    }

    /**
     * 编辑数据
     *
     * @param tbTesttype 实体
     * @return 编辑结果
     */
    @SaCheckRole("admin")
    @PostMapping("/update")
    public Result update(@RequestBody TbTesttype tbTesttype) {
        return this.tbTesttypeService.update(tbTesttype);
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
        return this.tbTesttypeService.delete(id);
    }

}

