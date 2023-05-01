package com.zero314.evaluatemanage.entity;

import java.io.Serializable;
import lombok.*;

/**
 * 用户表(TbUser)实体类
 *
 * @author yh
 * @since 2023-04-30 23:15:46
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TbUser implements Serializable {
    private static final long serialVersionUID = -89845065962627179L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户头像
     */
    private String headimg;
}

