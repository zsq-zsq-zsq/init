package com.template.springbootinitmaster.application;


import com.template.springbootinitmaster.infrastructure.common.core.exception.ServiceException;
import com.template.springbootinitmaster.infrastructure.common.core.utils.SpringUtils;
import com.template.springbootinitmaster.interfaces.vo.auth.LoginVo;



/**
 * 授权策略
 *
 */
public interface IAuthStrategy {

    String BASE_NAME = "AuthStrategy";

    /**
     * 登录
     *
     * @param body      登录对象
     * @param grantType 授权类型
     * @return 登录验证信息
     */
    static LoginVo login(String body,  String grantType) {
        // 授权类型和客户端id
        String beanName = grantType + BASE_NAME;
        if (!SpringUtils.containsBean(beanName)) {
            throw new ServiceException("授权类型不正确!");
        }
        IAuthStrategy instance = SpringUtils.getBean(beanName);
        return instance.login(body);
    }

    /**
     * 登录
     *
     * @param body   登录对象
     * @return 登录验证信息
     */
    LoginVo login(String body);

}
