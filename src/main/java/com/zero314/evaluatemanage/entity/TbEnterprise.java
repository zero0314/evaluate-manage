package com.zero314.evaluatemanage.entity;

import java.io.Serializable;
import lombok.*;

/**
 * 企业表(TbEnterprise)实体类
 *
 * @author yh
 * @since 2023-05-01 00:20:42
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TbEnterprise implements Serializable {
    private static final long serialVersionUID = 156540676192108331L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 企业名称
     */
    private String name;
    /**
     * 法人代表
     */
    private String representative;
    /**
     * 联系电话
     */
    private String telephone;
    /**
     * 企业地址
     */
    private String location;
    /**
     * 企业规模
     */
    private String scale;
    /**
     * 注册资本
     */
    private String registeredcapital;
    /**
     * 成立日期
     */
    private String date;
    /**
     * 用户id
     */
    private Integer userId;
}

