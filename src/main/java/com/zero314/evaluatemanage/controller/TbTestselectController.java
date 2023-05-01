package com.zero314.evaluatemanage.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.zero314.evaluatemanage.entity.TbTestselect;
import com.zero314.evaluatemanage.service.TbTestselectService;
import com.zero314.evaluatemanage.util.Result;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;

/**
 * 评价细则表(TbTestselect)表控制层
 *
 * @author yh
 * @since 2023-04-30 23:15:46
 */
@RestController
@RequestMapping("tbTestselect")
public class TbTestselectController {
    /**
     * 服务对象
     */
    @Resource
    private TbTestselectService tbTestselectService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @SaCheckRole("admin")
    @PostMapping("/query")
    public Result queryById(@RequestParam("id") Integer id) {
        return this.tbTestselectService.query(id);
    }
    
    /**
     * 分页查询
     *
     * @param tbTestselect 筛选条件
     * @return 查询结果
     */
    @SaCheckRole("admin")
    @PostMapping("/queryPage/{page}/{size}")
    public Result queryPage(@RequestBody TbTestselect tbTestselect,
                            @PathVariable Long page,
                            @PathVariable Long size) {
        return this.tbTestselectService.queryPage(tbTestselect, page, size);
    }
    
    /**
     * 列表查询
     *
     * @param tbTestselect 筛选条件
     * @return 查询结果
     */
    @SaCheckRole("admin")
    @PostMapping("/queryList")
    public Result queryList(@RequestBody TbTestselect tbTestselect) {
        return this.tbTestselectService.queryList(tbTestselect);
    }
    
    /**
     * 计数
     *
     * @param tbTestselect 筛选条件
     * @return 计数结果
     */
    @SaCheckRole("admin")
    @PostMapping("/count")
    public Result count(@RequestBody TbTestselect tbTestselect) {
        return this.tbTestselectService.count(tbTestselect);
    }

    /**
     * 新增数据
     *
     * @param tbTestselect 实体
     * @return 新增结果
     */
    @SaCheckRole("admin")
    @PostMapping("/insert")
    public Result insert(@RequestBody TbTestselect tbTestselect) {
        return this.tbTestselectService.insert(tbTestselect);
    }
    
    /**
     * 批量新增数据
     *
     * @param list 实体列表
     * @return 新增结果
     */
    @SaCheckRole("admin")
    @PostMapping("/insertBatch")
    public Result insertBatch(@RequestBody List<TbTestselect> list) {
        return this.tbTestselectService.insertBatch(list);
    }
    
    /**
     * 批量新增或按主键更新数据
     *
     * @param list 实体列表
     * @return 操作结果
     */
    @SaCheckRole("admin")
    @PostMapping("/insertOrUpdateBatch")
    public Result insertOrUpdateBatch(@RequestBody List<TbTestselect> list) {
        return this.tbTestselectService.insertOrUpdateBatch(list);
    }

    /**
     * 编辑数据
     *
     * @param tbTestselect 实体
     * @return 编辑结果
     */
    @SaCheckRole("admin")
    @PostMapping("/update")
    public Result update(@RequestBody TbTestselect tbTestselect) {
        return this.tbTestselectService.update(tbTestselect);
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
        return this.tbTestselectService.delete(id);
    }

}

