package com.zero314.evaluatemanage.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.zero314.evaluatemanage.entity.TbDimension;
import com.zero314.evaluatemanage.service.TbDimensionService;
import com.zero314.evaluatemanage.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评价模块表(TbDimension)表控制层
 *
 * @author yh
 * @since 2023-04-30 23:15:45
 */
@RestController
@RequestMapping("tbDimension")
public class TbDimensionController {
    /**
     * 服务对象
     */
    @Resource
    private TbDimensionService tbDimensionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @SaCheckRole("admin")
    @PostMapping("/query")
    public Result queryById(@RequestParam("id") Integer id) {
        return this.tbDimensionService.query(id);
    }
    
    /**
     * 分页查询
     *
     * @param tbDimension 筛选条件
     * @return 查询结果
     */
    @SaCheckRole("admin")
    @PostMapping("/queryPage/{page}/{size}")
    public Result queryPage(@RequestBody TbDimension tbDimension,
                            @PathVariable Long page,
                            @PathVariable Long size) {
        return this.tbDimensionService.queryPage(tbDimension, page, size);
    }
    
    /**
     * 列表查询
     *
     * @param tbDimension 筛选条件
     * @return 查询结果
     */
    @SaCheckRole("admin")
    @PostMapping("/queryList")
    public Result queryList(@RequestBody TbDimension tbDimension) {
        return this.tbDimensionService.queryList(tbDimension);
    }
    
    /**
     * 计数
     *
     * @param tbDimension 筛选条件
     * @return 计数结果
     */
    @SaCheckRole("admin")
    @PostMapping("/count")
    public Result count(@RequestBody TbDimension tbDimension) {
        return this.tbDimensionService.count(tbDimension);
    }

    /**
     * 新增数据
     *
     * @param tbDimension 实体
     * @return 新增结果
     */
    @SaCheckRole("admin")
    @PostMapping("/insert")
    public Result insert(@RequestBody TbDimension tbDimension) {
        return this.tbDimensionService.insert(tbDimension);
    }
    
    /**
     * 批量新增数据
     *
     * @param list 实体列表
     * @return 新增结果
     */
    @SaCheckRole("admin")
    @PostMapping("/insertBatch")
    public Result insertBatch(@RequestBody List<TbDimension> list) {
        return this.tbDimensionService.insertBatch(list);
    }
    
    /**
     * 批量新增或按主键更新数据
     *
     * @param list 实体列表
     * @return 操作结果
     */
    @SaCheckRole("admin")
    @PostMapping("/insertOrUpdateBatch")
    public Result insertOrUpdateBatch(@RequestBody List<TbDimension> list) {
        return this.tbDimensionService.insertOrUpdateBatch(list);
    }

    /**
     * 编辑数据
     *
     * @param tbDimension 实体
     * @return 编辑结果
     */
    @SaCheckRole("admin")
    @PostMapping("/update")
    public Result update(@RequestBody TbDimension tbDimension) {
        return this.tbDimensionService.update(tbDimension);
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
        return this.tbDimensionService.delete(id);
    }

}

