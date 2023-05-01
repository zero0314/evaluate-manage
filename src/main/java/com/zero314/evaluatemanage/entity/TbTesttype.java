package com.zero314.evaluatemanage.entity;

import java.io.Serializable;
import lombok.*;

/**
 * 评价域表(TbTesttype)实体类
 *
 * @author yh
 * @since 2023-04-30 23:15:46
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TbTesttype implements Serializable {
    private static final long serialVersionUID = 233332694059879282L;
    /**
     * 主键
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
     * 维度id
     */
    private Integer dimensionId;
}

