package com.template.springbootinitmaster.infrastructure.common.satoken.config;

import cn.dev33.satoken.dao.SaTokenDao;
import cn.dev33.satoken.jwt.StpLogicJwtForSimple;
import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpLogic;
import com.template.springbootinitmaster.infrastructure.common.satoken.core.dao.PlusSaTokenDao;
import com.template.springbootinitmaster.infrastructure.common.satoken.core.service.SaPermissionImpl;
import com.template.springbootinitmaster.infrastructure.common.satoken.handler.SaTokenExceptionHandler;




import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * sa-token 配置
 *
 */
@Configuration
public class SaTokenConfig {

    @Bean
    public StpLogic getStpLogicJwt() {
        // Sa-Token 整合 jwt (简单模式)
        return new StpLogicJwtForSimple();
    }

    /**
     * 权限接口实现(使用bean注入方便用户替换)
     */
    @Bean
    public StpInterface stpInterface() {
        return new SaPermissionImpl();
    }

    /**
     * 自定义dao层存储
     */
    @Bean
    public SaTokenDao saTokenDao() {
        return new PlusSaTokenDao();
    }

    /**
     * 异常处理器
     */
    @Bean
    public SaTokenExceptionHandler saTokenExceptionHandler() {
        return new SaTokenExceptionHandler();
    }

}
