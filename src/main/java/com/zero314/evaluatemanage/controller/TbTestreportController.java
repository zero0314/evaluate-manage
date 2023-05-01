package com.zero314.evaluatemanage.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.zero314.evaluatemanage.entity.TbTestreport;
import com.zero314.evaluatemanage.service.TbTestreportService;
import com.zero314.evaluatemanage.util.Result;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 测试报告表(TbTestreport)表控制层
 *
 * @author yh
 * @since 2023-04-30 23:15:46
 */
@RestController
@RequestMapping("tbTestreport")
public class TbTestreportController {
    /**
     * 服务对象
     */
    @Resource
    private TbTestreportService tbTestreportService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @SaCheckRole("admin")
    @PostMapping("/query")
    public Result queryById(@RequestParam("id") Integer id) {
        return this.tbTestreportService.query(id);
    }

    /**
     * 分页查询
     *
     * @param tbTestreport 筛选条件
     * @return 查询结果
     */
    @SaCheckRole("admin")
    @PostMapping("/queryPage/{page}/{size}")
    public Result queryPage(@RequestBody TbTestreport tbTestreport,
                            @PathVariable Long page,
                            @PathVariable Long size) {
        return this.tbTestreportService.queryPage(tbTestreport, page, size);
    }

    /**
     * 列表查询
     *
     * @param tbTestreport 筛选条件
     * @return 查询结果
     */
    @SaCheckRole("admin")
    @PostMapping("/queryList")
    public Result queryList(@RequestBody TbTestreport tbTestreport) {
        return this.tbTestreportService.queryList(tbTestreport);
    }

    /**
     * 计数
     *
     * @param tbTestreport 筛选条件
     * @return 计数结果
     */
    @SaCheckRole("admin")
    @PostMapping("/count")
    public Result count(@RequestBody TbTestreport tbTestreport) {
        return this.tbTestreportService.count(tbTestreport);
    }

    /**
     * 查询最近n次测试报告的模块分
     *
     * @param size 数量
     * @return 结果
     */
    @SaCheckRole("user")
    @PostMapping("/queryHistory")
    public Result queryHistory(@RequestParam("size") Integer size) {
        return this.tbTestreportService.queryHistory(size);
    }

    /**
     * 新增数据
     *
     * @param tbTestreport 实体
     * @return 新增结果
     */
    @SaCheckRole("admin")
    @PostMapping("/insert")
    public Result insert(@RequestBody TbTestreport tbTestreport) {
        return this.tbTestreportService.insert(tbTestreport);
    }

    /**
     * 初始化测试报告
     *
     * @return 新增结果
     */
    @SaCheckRole("user")
    @PostMapping("/init")
    public Result init() {
        return this.tbTestreportService.init();
    }

    /**
     * 批量新增数据
     *
     * @param list 实体列表
     * @return 新增结果
     */
    @SaCheckRole("admin")
    @PostMapping("/insertBatch")
    public Result insertBatch(@RequestBody List<TbTestreport> list) {
        return this.tbTestreportService.insertBatch(list);
    }

    /**
     * 批量新增或按主键更新数据
     *
     * @param list 实体列表
     * @return 操作结果
     */
    @SaCheckRole("admin")
    @PostMapping("/insertOrUpdateBatch")
    public Result insertOrUpdateBatch(@RequestBody List<TbTestreport> list) {
        return this.tbTestreportService.insertOrUpdateBatch(list);
    }

    /**
     * 编辑数据
     *
     * @param tbTestreport 实体
     * @return 编辑结果
     */
    @SaCheckRole("admin")
    @PostMapping("/update")
    public Result update(@RequestBody TbTestreport tbTestreport) {
        return this.tbTestreportService.update(tbTestreport);
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
        return this.tbTestreportService.delete(id);
    }

    /**
     * Excel导出测试报告
     *
     */
    @SaCheckRole("user")
    @PostMapping("/export")
    public void export(@RequestParam("id") Integer id,
                       HttpServletResponse response) {
        this.tbTestreportService.export(id, response);
    }
}

