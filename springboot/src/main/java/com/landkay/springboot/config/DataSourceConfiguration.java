package com.landkay.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 90818
 * @Title: DataSourceConfiguration
 * @ProjectName springboot
 * @Description: TODO
 * @date 2018/8/217:45
 */
@Configuration
public class DataSourceConfiguration {

    /*@Bean
    public BasicDataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxIdle(maxIdel);
        dataSource.setMaxWait(maxWait);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(true);
        return dataSource;
    }*/
}
