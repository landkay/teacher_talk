package com.landkay.springboot.config;

import com.landkay.springboot.filter.MainFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 90818
 * @Title: FilterConfig
 * @ProjectName springboot
 * @Description: TODO
 * @date 2018/8/216:23
 */
@Configuration
public class FilterConfig {

    @Bean
    MainFilter getMainFilter() {
        return new MainFilter();
    }

    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        //新建过滤器注册类
        FilterRegistrationBean registration = new FilterRegistrationBean();
        // 添加我们写好的过滤器
        registration.setFilter(getMainFilter());
        // 设置过滤器的URL模式
        registration.addUrlPatterns("/*");
        return registration;
    }
}
