package com.template.springbootinitmaster.infrastructure.common.core.domain.model;



import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

/**
 * 登录用户身份权限
 *
 */
@Data
@NoArgsConstructor
public class LoginUser implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    /**
     * 用户ID
     */
    private Long userId;



    /**
     * 用户唯一标识
     */
    private String token;

    /**
     * 用户类型
     */
    private String userType;

    /**
     * 登录时间
     */
    private Long loginTime;

    /**
     * 过期时间
     */
    private Long expireTime;

    /**
     * 登录IP地址
     */
    private String ipaddr;

    /**
     * 登录地点
     */
    private String loginLocation;

    /**
     * 浏览器类型
     */
    private String browser;

    /**
     * 操作系统
     */
    private String os;



    /**
     * 角色权限
     */
    private String rolePermission;

    /**
     * 用户名
     */
    private String userAccount;

    /**
     * 用户昵称
     */
    private String userName;




    /**
     * 客户端
     */
    private String clientKey;

    /**
     * 设备类型
     */
    private String deviceType;



}
