package com.zero314.evaluatemanage.entity;

import java.io.Serializable;
import lombok.*;

/**
 * 测试报告表(TbTestreport)实体类
 *
 * @author yh
 * @since 2023-05-01 07:50:48
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TbTestreport implements Serializable {
    private static final long serialVersionUID = -23097638996067448L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 总分
     */
    private Double finalpoint;
    /**
     * 模块分
     */
    private String dimensionpoint;
    /**
     * 单项分
     */
    private String typepoint;
    /**
     * 建议
     */
    private String suggestion;
    /**
     * 漏洞
     */
    private String bug;
    /**
     * 开始时间
     */
    private String createtime;
    /**
     * 结束时间
     */
    private String endtime;
    /**
     * 用户id
     */
    private Integer userId;
}

