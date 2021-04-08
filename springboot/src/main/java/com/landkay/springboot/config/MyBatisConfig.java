package com.landkay.springboot.config;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

/**
 * @author 90818
 * @Title: MyBatisConfig
 * @ProjectName springboot
 * @Description: TODO
 * @date 2018/8/217:44
 */
@EnableTransactionManagement
public class MyBatisConfig implements TransactionManagementConfigurer {
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return null;
    }
}
