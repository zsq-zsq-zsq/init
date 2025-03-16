package com.template.springbootinitmaster.application;

import com.baomidou.mybatisplus.extension.service.IService;
import com.template.springbootinitmaster.interfaces.dto.user.UserDto;
import com.template.springbootinitmaster.domain.user.entity.User;
import com.template.springbootinitmaster.interfaces.vo.user.UserVo;


public interface UserApplicationService extends IService<User> {
    Integer register(UserDto userDto);

    UserVo getUserProfile();
}
