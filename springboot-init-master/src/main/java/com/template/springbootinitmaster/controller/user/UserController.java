package com.template.springbootinitmaster.controller.user;


import com.template.springbootinitmaster.common.core.domain.R;
import com.template.springbootinitmaster.domain.vo.UserVo;
import com.template.springbootinitmaster.service.UserService;
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


    private final UserService userService;


    /**
     * 获取用户信息
     * @return
     */
    @GetMapping("/profile")
    public R<UserVo> userProfile(){

        return R.ok(userService.getUserProfile());
    }
}
