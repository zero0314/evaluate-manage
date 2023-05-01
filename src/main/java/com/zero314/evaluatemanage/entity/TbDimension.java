package com.zero314.evaluatemanage.entity;

import java.io.Serializable;
import lombok.*;

/**
 * 评价模块表(TbDimension)实体类
 *
 * @author yh
 * @since 2023-04-30 23:15:45
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TbDimension implements Serializable {
    private static final long serialVersionUID = 785594919424905643L;
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
}

