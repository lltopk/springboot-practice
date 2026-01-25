package com.lyflexi.springboothttp.config;

import com.lyflexi.springboothttp.filter.RepeatableFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Filter 注册配置
 */
@Configuration
public class FilterConfig {

    /**
     * 注册一个最高优先级的FilterRegistrationBean
     * @return
     */
    @Bean
    public FilterRegistrationBean<RepeatableFilter> repeatableFilterRegistration() {
        FilterRegistrationBean<RepeatableFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new RepeatableFilter());
        registration.addUrlPatterns("/*");
        registration.setName("repeatableFilter");
        registration.setOrder(1); // 优先级必须足够高
        return registration;
    }
}
