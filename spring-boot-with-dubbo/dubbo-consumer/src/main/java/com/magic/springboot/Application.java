package com.magic.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Created by chloneda
 */
@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"com.magic.springboot", "com.magic.springboot.dubbo"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
