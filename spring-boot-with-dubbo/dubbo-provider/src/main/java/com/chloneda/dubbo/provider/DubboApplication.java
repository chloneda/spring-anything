package com.chloneda.dubbo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Created by chloneda
 */
@ComponentScan(basePackages = {"com.chloneda.dubbo.provider", "com.chloneda.dubbo"})
@EnableConfigurationProperties
@SpringBootApplication
@Configuration
public class DubboApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboApplication.class, args);
    }
}
