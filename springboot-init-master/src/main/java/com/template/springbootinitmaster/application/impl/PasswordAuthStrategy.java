package com.template.springbootinitmaster.application.impl;

import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.template.springbootinitmaster.infrastructure.common.core.constant.SystemConstants;
import com.template.springbootinitmaster.infrastructure.common.core.domain.model.LoginUser;
import com.template.springbootinitmaster.infrastructure.common.core.exception.user.UserException;
import com.template.springbootinitmaster.infrastructure.common.core.utils.MapstructUtils;
import com.template.springbootinitmaster.infrastructure.common.json.utils.JsonUtils;
import com.template.springbootinitmaster.infrastructure.common.satoken.helper.LoginHelper;
import com.template.springbootinitmaster.infrastructure.common.valid.ValidatorUtils;
import com.template.springbootinitmaster.domain.user.entity.User;
import com.template.springbootinitmaster.interfaces.dto.auth.PasswordLoginBody;
import com.template.springbootinitmaster.interfaces.vo.auth.LoginVo;
import com.template.springbootinitmaster.interfaces.vo.user.UserVo;
import com.template.springbootinitmaster.application.IAuthStrategy;
import com.template.springbootinitmaster.application.UserApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 密码认证策略
 *
 */
@Slf4j
@Service("password" + IAuthStrategy.BASE_NAME)
@RequiredArgsConstructor
public class PasswordAuthStrategy implements IAuthStrategy {


    private final UserApplicationService userService;

    private final LoginService loginService;

    @Override
    public LoginVo login(String body) {
        //参数校验
        PasswordLoginBody loginBody = JsonUtils.parseObject(body, PasswordLoginBody.class);
        ValidatorUtils.validate(loginBody);
        //读取数据库内用户信息
        UserVo user = loadUserByUserAccout(loginBody.getUserAccount());
        //检测密码准确
        loginService.checkLogin(loginBody.getUserAccount(), () -> !BCrypt.checkpw(loginBody.getUserPassword(), user.getUserPassword()));
        //创建登录对象
        LoginUser loginUser = loginService.buildLoginUser(user);
        SaLoginModel model = new SaLoginModel();
        //登录
        LoginHelper.login(loginUser, model);
        //返回登录对象
        LoginVo loginVo = new LoginVo();
        loginVo.setAccessToken(StpUtil.getTokenValue());
        loginVo.setExpireIn(StpUtil.getTokenTimeout());

        return loginVo;
    }



    private UserVo loadUserByUserAccout(String userAccount) {
        User user = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getUserAccount, userAccount));
        if (ObjectUtil.isNull(user)) {
            log.info("登录用户：{} 不存在.", userAccount);
            throw new UserException("用户不存在", userAccount);
        } else if (SystemConstants.DISABLE.equals(user.getStatus())) {
            log.info("登录用户：{} 已被停用.", userAccount);
            throw new UserException("用户被停用", userAccount);
        }
        UserVo userVo = MapstructUtils.convert(user, UserVo.class);
        return userVo;
    }

}
