package com.landkay.springboot.startup;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
//@RefreshScope
//@EnableEurekaClient
//@EnableFeignClients
@SpringBootApplication
@ComponentScan(basePackages = "com.landkay.springboot")
@EnableScheduling
@MapperScan("com.landkay.springboot.dao")
/**
 * Description // springboot 启动类
 * @author landkay
 * @Date 10:54 2018/8/3
 **/
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}