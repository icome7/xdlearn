package com.iseven.learn.xdlearn.configuration;

import com.iseven.learn.xdlearn.interceptor.CorsInterceptor;
import com.iseven.learn.xdlearn.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 * <p>
 * 不用权限可以访问url    /api/v1/pub/
 * 要登录可以访问url    /api/v1/pri/
 */

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Autowired
    private CorsInterceptor corsInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        /**
         * 拦截全部路径，这个跨域需要放在最上面
         */
        registry.addInterceptor(corsInterceptor).addPathPatterns("/**");

        registry.addInterceptor(loginInterceptor).addPathPatterns("/api/v1/pri/*/*/**")
                //不拦截哪些路径   斜杠一定要加
                .excludePathPatterns("/api/v1/pri/user/login", "/api/v1/pri/user/register");

    }
}
