package com.template.springbootinitmaster.interfaces.vo.user;


import com.template.springbootinitmaster.domain.user.entity.User;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@AutoMapper(target = User.class)
public class UserVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 状态
     */
    private String status;

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
     * 密码，加密存储
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
