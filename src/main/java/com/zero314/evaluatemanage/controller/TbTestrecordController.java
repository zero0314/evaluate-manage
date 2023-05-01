package com.zero314.evaluatemanage.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.zero314.evaluatemanage.entity.TbTestrecord;
import com.zero314.evaluatemanage.service.TbTestrecordService;
import com.zero314.evaluatemanage.util.Result;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;

/**
 * 评价记录表(TbTestrecord)表控制层
 *
 * @author yh
 * @since 2023-04-30 23:15:46
 */
@RestController
@RequestMapping("tbTestrecord")
public class TbTestrecordController {
    /**
     * 服务对象
     */
    @Resource
    private TbTestrecordService tbTestrecordService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @SaCheckRole("admin")
    @PostMapping("/query")
    public Result queryById(@RequestParam("id") Integer id) {
        return this.tbTestrecordService.query(id);
    }

    /**
     * 分页查询
     *
     * @param tbTestrecord 筛选条件
     * @return 查询结果
     */
    @SaCheckRole("admin")
    @PostMapping("/queryPage/{page}/{size}")
    public Result queryPage(@RequestBody TbTestrecord tbTestrecord,
                            @PathVariable Long page,
                            @PathVariable Long size) {
        return this.tbTestrecordService.queryPage(tbTestrecord, page, size);
    }

    /**
     * 列表查询
     *
     * @param tbTestrecord 筛选条件
     * @return 查询结果
     */
    @SaCheckRole("admin")
    @PostMapping("/queryList")
    public Result queryList(@RequestBody TbTestrecord tbTestrecord) {
        return this.tbTestrecordService.queryList(tbTestrecord);
    }

    /**
     * 计数
     *
     * @param tbTestrecord 筛选条件
     * @return 计数结果
     */
    @SaCheckRole("admin")
    @PostMapping("/count")
    public Result count(@RequestBody TbTestrecord tbTestrecord) {
        return this.tbTestrecordService.count(tbTestrecord);
    }

    /**
     * 新增数据
     *
     * @param tbTestrecord 实体
     * @return 新增结果
     */
    @SaCheckRole("admin")
    @PostMapping("/insert")
    public Result insert(@RequestBody TbTestrecord tbTestrecord) {
        return this.tbTestrecordService.insert(tbTestrecord);
    }


    /**
     * 提交答案
     *
     * @param list 实体列表
     * @return 新增结果
     */
    @SaCheckRole("user")
    @PostMapping("/postAnswer")
    public Result postAnswer(@RequestBody List<TbTestrecord> list) {

        return this.tbTestrecordService.postAnswer(list);
    }

    /**
     * 批量新增数据
     *
     * @param list 实体列表
     * @return 新增结果
     */
    @SaCheckRole("admin")
    @PostMapping("/insertBatch")
    public Result insertBatch(@RequestBody List<TbTestrecord> list) {
        return this.tbTestrecordService.insertBatch(list);
    }

    /**
     * 批量新增或按主键更新数据
     *
     * @param list 实体列表
     * @return 操作结果
     */
    @SaCheckRole("admin")
    @PostMapping("/insertOrUpdateBatch")
    public Result insertOrUpdateBatch(@RequestBody List<TbTestrecord> list) {
        return this.tbTestrecordService.insertOrUpdateBatch(list);
    }

    /**
     * 编辑数据
     *
     * @param tbTestrecord 实体
     * @return 编辑结果
     */
    @SaCheckRole("admin")
    @PostMapping("/update")
    public Result update(@RequestBody TbTestrecord tbTestrecord) {
        return this.tbTestrecordService.update(tbTestrecord);
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
        return this.tbTestrecordService.delete(id);
    }

}

