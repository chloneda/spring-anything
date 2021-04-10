package com.chloneda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Created by chloneda
 */
@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"com.chloneda", "com.chloneda.dubbo"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
