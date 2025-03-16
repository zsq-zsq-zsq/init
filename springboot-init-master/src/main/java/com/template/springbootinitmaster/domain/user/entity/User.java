package com.template.springbootinitmaster.domain.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.template.springbootinitmaster.infrastructure.common.mybatis.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户
 * @TableName user
 */
@TableName(value ="user")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {
    /**
     * 用户ID
     */
    @TableId(value = "id")
    private Long id;


    /**
     * 状态
     */
    private String status;

    /**
     * 是否删除
     */
    @TableLogic
    private Integer isDelete;

    /**
     * 最后登录的ip
     */
    private String loginIp;

    /**
     * 最后登录的时间
     */
    private Date loginDate;

    /**
     * 账号
     */
    private String userAccount;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 用户简介
     */
    private String userProfile;

    /**
     * 用户角色：user/admin/ban
     */
    private String userRole;










}