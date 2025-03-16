package com.template.springbootinitmaster.interfaces.controller.auth;

import cn.dev33.satoken.annotation.SaIgnore;
import com.template.springbootinitmaster.infrastructure.common.core.domain.R;
import com.template.springbootinitmaster.infrastructure.common.json.utils.JsonUtils;
import com.template.springbootinitmaster.infrastructure.common.valid.ValidatorUtils;
import com.template.springbootinitmaster.interfaces.controller.BaseController;
import com.template.springbootinitmaster.interfaces.dto.auth.LoginBody;
import com.template.springbootinitmaster.interfaces.dto.auth.RegisterBody;
import com.template.springbootinitmaster.interfaces.vo.auth.LoginVo;
import com.template.springbootinitmaster.application.IAuthStrategy;
import com.template.springbootinitmaster.application.impl.LoginService;
import com.template.springbootinitmaster.application.impl.RegisterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@Slf4j
@SaIgnore
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController extends BaseController {


    private final RegisterService registerService;
    private final LoginService loginService;


    /**
     * 用户注册
     */
    @PostMapping("/register")
    public R<Void> register(@Validated @RequestBody RegisterBody user) {
        //注册用户
        registerService.register(user);

        return R.ok();
    }


    /**
     * 登录方法
     *
     * @param body 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public R<LoginVo> login(@RequestBody String body) {
        //1.转换参数类型，参数校验
        LoginBody loginBody = JsonUtils.parseObject(body, LoginBody.class);
        ValidatorUtils.validate(loginBody);
        //2.登录校验
        LoginVo loginVo = IAuthStrategy.login(body,loginBody.getGrantType());

        return R.ok(loginVo);
    }

    /**
     * 退出登录
     * @return
     */
    @PostMapping("/logout")
    public R<Void> logout() {

        loginService.logout();

        return R.ok();
    }




}
