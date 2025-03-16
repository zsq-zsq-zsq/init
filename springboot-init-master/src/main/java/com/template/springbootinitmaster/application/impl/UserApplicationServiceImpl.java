package com.template.springbootinitmaster.application.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.template.springbootinitmaster.infrastructure.common.core.domain.model.LoginUser;
import com.template.springbootinitmaster.infrastructure.common.core.exception.user.UserException;
import com.template.springbootinitmaster.infrastructure.common.core.utils.MapstructUtils;
import com.template.springbootinitmaster.infrastructure.common.satoken.helper.LoginHelper;
import com.template.springbootinitmaster.interfaces.dto.user.UserDto;
import com.template.springbootinitmaster.domain.user.entity.User;
import com.template.springbootinitmaster.interfaces.vo.user.UserVo;
import com.template.springbootinitmaster.infrastructure.mapper.UserMapper;
import com.template.springbootinitmaster.application.UserApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author 张绍启
 * @description 针对表【user(用户)】的数据库操作Service实现
 * @createDate 2025-02-19 10:13:50
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserApplicationServiceImpl extends ServiceImpl<UserMapper, User> implements UserApplicationService {

    private final UserMapper baseMapper;


    /**
     * 添加用户
     * @param userDto
     * @return
     */
    @Override
    public Integer register(UserDto userDto) {
        //转换类型
        User user = MapstructUtils.convert(userDto, User.class);
        //判断用户是否存在
        boolean exist =baseMapper.exists(new LambdaQueryWrapper<User>()
                .eq(User::getUserAccount, user.getUserAccount()));
        //如果存在，抛出异常
        if(exist){
            throw new UserException("user.register.save.error", user.getUserAccount());
        }
        //保存用户
        return baseMapper.insert(user);
    }

    /**
     * 获取用户信息
     * @return
     */
    @Override
    public UserVo getUserProfile() {
        //获取当前登录用户
        LoginUser loginUser = LoginHelper.getLoginUser();
        //根据当前登录用户id查询用户信息
        UserVo userVo = baseMapper.selectVoById(loginUser.getUserId());
        //返回
        return userVo;
    }
}