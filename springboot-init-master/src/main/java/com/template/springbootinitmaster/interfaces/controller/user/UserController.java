package com.template.springbootinitmaster.interfaces.controller.user;


import com.template.springbootinitmaster.infrastructure.common.core.domain.R;
import com.template.springbootinitmaster.interfaces.vo.user.UserVo;
import com.template.springbootinitmaster.application.UserApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {


    private final UserApplicationService userService;


    /**
     * 获取用户信息
     * @return
     */
    @GetMapping("/profile")
    public R<UserVo> userProfile(){

        return R.ok(userService.getUserProfile());
    }
}
