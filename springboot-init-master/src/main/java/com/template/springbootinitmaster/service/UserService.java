package com.template.springbootinitmaster.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.template.springbootinitmaster.domain.dto.UserDto;
import com.template.springbootinitmaster.domain.entity.User;
import com.template.springbootinitmaster.domain.vo.UserVo;


public interface UserService extends IService<User> {
    Integer register(UserDto userDto);

    UserVo getUserProfile();
}
