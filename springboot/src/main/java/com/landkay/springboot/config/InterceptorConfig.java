package com.landkay.springboot.config;

import com.landkay.springboot.interceptor.MainInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author 90818
 * @Title: WebAppConfig
 * @ProjectName springboot
 * @Description: TODO
 * @date 2018/8/215:51
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Bean
    MainInterceptor getMainInterceptor(){
        return new MainInterceptor();
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(getMainInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
