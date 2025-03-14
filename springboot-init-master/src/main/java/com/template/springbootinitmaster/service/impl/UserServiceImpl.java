package com.template.springbootinitmaster.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.template.springbootinitmaster.common.core.domain.model.LoginUser;
import com.template.springbootinitmaster.common.core.exception.user.UserException;
import com.template.springbootinitmaster.common.core.utils.MapstructUtils;
import com.template.springbootinitmaster.common.satoken.helper.LoginHelper;
import com.template.springbootinitmaster.domain.dto.UserDto;
import com.template.springbootinitmaster.domain.entity.User;
import com.template.springbootinitmaster.domain.vo.UserVo;
import com.template.springbootinitmaster.mapper.UserMapper;
import com.template.springbootinitmaster.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserMapper baseMapper;
    private final UserMapper userMapper;

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
        UserVo userVo = userMapper.selectVoById(loginUser.getUserId());
        //返回
        return userVo;
    }
}