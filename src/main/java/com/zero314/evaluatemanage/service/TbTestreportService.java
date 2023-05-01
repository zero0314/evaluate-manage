package com.zero314.evaluatemanage.service;

import com.zero314.evaluatemanage.entity.TbTestreport;
import com.zero314.evaluatemanage.util.Result;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 测试报告表(TbTestreport)表服务接口
 *
 * @author yh
 * @since 2023-04-30 23:15:46
 */
public interface TbTestreportService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Result query(Integer id);

    /**
     * 分页查询
     *
     * @param tbTestreport 筛选条件
     * @param page         页码
     * @param size         大小
     * @return 分页对象
     */
    Result queryPage(TbTestreport tbTestreport, Long page, Long size);

    /**
     * 列表查询
     *
     * @param tbTestreport 筛选条件
     * @return 对象列表
     */
    Result queryList(TbTestreport tbTestreport);

    /**
     * 统计总行数
     *
     * @param tbTestreport 查询条件
     * @return 总行数
     */
    Result count(TbTestreport tbTestreport);

    /**
     * 查询最近n次测试报告的模块分
     *
     * @param size   数量
     * @return 结果
     */
    Result queryHistory(Integer size);

    /**
     * 新增数据
     *
     * @param tbTestreport 实例对象
     * @return 影响行数
     */
    Result insert(TbTestreport tbTestreport);

    /**
     * 初始化测试报告
     *
     * @return 新增结果
     */
    Result init();

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param list List<TbTestreport> 实例对象列表
     * @return 影响行数
     */
    Result insertBatch(List<TbTestreport> list);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param list List<TbTestreport> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    Result insertOrUpdateBatch(List<TbTestreport> list);

    /**
     * 修改数据
     *
     * @param tbTestreport 实例对象
     * @return 实例对象
     */
    Result update(TbTestreport tbTestreport);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    Result delete(Integer id);

    /**
     * Excel导出测试报告
     * @param id 报告
     */
    void export(Integer id, HttpServletResponse response);
}
