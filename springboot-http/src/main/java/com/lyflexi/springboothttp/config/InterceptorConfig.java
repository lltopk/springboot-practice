package com.lyflexi.springboothttp.config;

import com.lyflexi.springboothttp.intercepter.UserHttpInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserHttpInterceptor())
                .addPathPatterns("/**") // 指定拦截所有请求
                .excludePathPatterns("/excludePath"); // 排除某些路径不进行拦截
    }
}