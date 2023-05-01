package com.zero314.evaluatemanage.entity;

import java.io.Serializable;
import lombok.*;

/**
 * 评价记录表(TbTestrecord)实体类
 *
 * @author yh
 * @since 2023-04-30 23:15:46
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TbTestrecord implements Serializable {
    private static final long serialVersionUID = 681990641572768896L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 得分
     */
    private Double score;
    /**
     * 评价点id
     */
    private Integer pointId;
    /**
     * 评分细则id
     */
    private Integer selectId;
    /**
     * 评分报告id
     */
    private Integer reportId;
}

