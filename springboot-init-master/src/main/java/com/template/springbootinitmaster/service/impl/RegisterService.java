package com.template.springbootinitmaster.service.impl;

import cn.dev33.satoken.secure.BCrypt;
import com.template.springbootinitmaster.common.core.enums.UserStatus;
import com.template.springbootinitmaster.common.core.exception.user.UserException;
import com.template.springbootinitmaster.domain.dto.UserDto;
import com.template.springbootinitmaster.domain.model.auth.RegisterBody;
import com.template.springbootinitmaster.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 注册
 */
@RequiredArgsConstructor
@Service
public class RegisterService {

    private final UserService userService;

    /**
     * 注册用户
     */
    public void register(RegisterBody registerBody) {
        //构造用户
        UserDto userDto = new UserDto();
        userDto.setUserAccount(registerBody.getUserAccount());
        userDto.setUserPassword(BCrypt.hashpw(registerBody.getUserPassword()));
        userDto.setUserName(registerBody.getUserAccount());
        userDto.setStatus(UserStatus.OK.getCode());

        //注册用户
        Integer result = userService.register(userDto);

        //如果注册失败，抛出异常
        if(result<=0){
            throw new UserException("用户已存在");
        }
    }
}
