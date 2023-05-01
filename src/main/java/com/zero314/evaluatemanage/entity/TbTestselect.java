package com.zero314.evaluatemanage.entity;

import java.io.Serializable;
import lombok.*;

/**
 * 评价细则表(TbTestselect)实体类
 *
 * @author yh
 * @since 2023-04-30 23:15:46
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TbTestselect implements Serializable {
    private static final long serialVersionUID = 635266478309687082L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 评分细则
     */
    private String name;
    /**
     * 分数
     */
    private Double score;
    /**
     * 评价点id
     */
    private Integer pointId;
}

