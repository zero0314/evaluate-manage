package com.zero314.evaluatemanage.entity;

import java.io.Serializable;
import lombok.*;

/**
 * 用户-角色关联表(TbUserRole)实体类
 *
 * @author yh
 * @since 2023-04-30 23:15:46
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TbUserRole implements Serializable {
    private static final long serialVersionUID = -93134027585323278L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 角色id
     */
    private Integer roleId;
}

