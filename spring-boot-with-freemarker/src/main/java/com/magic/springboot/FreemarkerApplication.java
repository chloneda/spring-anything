package com.magic.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Created by chl
 * Description:
 */
@SpringBootApplication
public class FreemarkerApplication extends SpringBootServletInitializer {

    private static Logger LOGGER = LoggerFactory.getLogger(FreemarkerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(FreemarkerApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FreemarkerApplication.class);
    }

}