package com.zero314.evaluatemanage.entity;

import java.io.Serializable;
import lombok.*;

/**
 * 角色表(TbRole)实体类
 *
 * @author yh
 * @since 2023-04-30 23:15:45
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TbRole implements Serializable {
    private static final long serialVersionUID = 470985897195062859L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
}

