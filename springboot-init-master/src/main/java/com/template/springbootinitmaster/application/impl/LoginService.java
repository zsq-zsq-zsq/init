package com.template.springbootinitmaster.application.impl;




import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import com.template.springbootinitmaster.infrastructure.common.core.domain.model.LoginUser;
import com.template.springbootinitmaster.infrastructure.common.core.exception.user.UserException;
import com.template.springbootinitmaster.infrastructure.common.satoken.helper.LoginHelper;
import com.template.springbootinitmaster.interfaces.vo.user.UserVo;
import org.springframework.stereotype.Service;
import java.util.function.Supplier;

/**
 * 登录服务
 */
@Service
public class LoginService {



    /**
     * 登录校验
     */
    public void checkLogin(String username, Supplier<Boolean> supplier) {
        if(supplier.get()) {
            throw new UserException("登录失败");
        }
    }


    /**
     * 退出登录
     */
    public void logout(){
        //获取当前登录对象
        LoginUser loginUser = LoginHelper.getLoginUser();
        if(ObjectUtil.isNull(loginUser)){
            return ;
        }
        StpUtil.logout();
    }


    /**
     * 构建登录用户
     */
    public LoginUser buildLoginUser(UserVo user) {
        LoginUser loginUser = new LoginUser();
        Long userId = user.getId();
        loginUser.setUserId(userId);
        loginUser.setUserName(user.getUserName());
        loginUser.setUserAccount(user.getUserAccount());
        loginUser.setRolePermission(user.getUserRole());

        return loginUser;
    }
}
