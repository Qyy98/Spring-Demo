package com.example.springdemo.general.sign;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FilterConfig
 *
 * @Description
 * @Author QianYiyu
 * @Date 2022/08/28 20:09
 */
@Configuration
public class FilterConfig {
    @Bean
    public RequestCachingFilter requestCachingFilter() {
        return new RequestCachingFilter();
    }

    @Bean
    public FilterRegistrationBean requestCachingFilterRegistration(
            RequestCachingFilter requestCachingFilter) {
        FilterRegistrationBean bean = new FilterRegistrationBean(requestCachingFilter);
        bean.setOrder(1);
        return bean;
    }
}
