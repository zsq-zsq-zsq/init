package com.template.springbootinitmaster.infrastructure.mapper;

import com.template.springbootinitmaster.infrastructure.common.mybatis.core.mapper.BaseMapperPlus;
import com.template.springbootinitmaster.domain.user.entity.User;
import com.template.springbootinitmaster.interfaces.vo.user.UserVo;


public interface UserMapper extends BaseMapperPlus<User, UserVo> {

}
