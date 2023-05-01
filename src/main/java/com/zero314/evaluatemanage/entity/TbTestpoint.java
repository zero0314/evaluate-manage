package com.zero314.evaluatemanage.entity;

import java.io.Serializable;
import lombok.*;

/**
 * 评价点表(TbTestpoint)实体类
 *
 * @author yh
 * @since 2023-05-01 00:49:06
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TbTestpoint implements Serializable {
    private static final long serialVersionUID = -14675735385471656L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 权重
     */
    private Double weight;
    /**
     * 低于9分的建议
     */
    private String firstsuggestion;
    /**
     * 低于5分的建议
     */
    private String secondsuggestion;
    /**
     * 低于3分的建议
     */
    private String thirdsuggestion;
    /**
     * 漏洞（低于5分）
     */
    private String bug;
    /**
     * 评价类别id
     */
    private Integer typeId;
}

