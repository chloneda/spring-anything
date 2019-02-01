package com.magic.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by chl
 * Description:
 */
@EnableTransactionManagement//启动事务
@SpringBootApplication
@MapperScan("com.magic.springboot.mapper")
public class MybatisApplication extends SpringBootServletInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MybatisApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MybatisApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MybatisApplication.class, args);
    }
}
