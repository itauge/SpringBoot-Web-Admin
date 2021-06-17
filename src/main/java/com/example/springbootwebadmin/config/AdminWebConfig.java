package com.example.springbootwebadmin.config;

import com.example.springbootwebadmin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 1. 編寫一個攔截器實現HandlerInterceptor接口
 * 2. 攔截器注冊到容器中(實現WebMvcConfigurer的addInterceptors)
 * 3. 指定攔截規則[如果是攔截所有靜態資源會被攔截]
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")//所有請求都會被攔截，包括靜態資源
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**","/city");//放行的請求
    }
}
