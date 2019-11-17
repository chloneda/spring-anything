package com.chloneda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Created by chloneda
 * @Description: Mybatis没有自动建表功能，可以结合Hibernate实现自动创建表，
 * 引入Hibernate，仅仅使用Hibernate自动创建表的属性。
 */
//启动事务
@EnableTransactionManagement
@SpringBootApplication
@MapperScan("com.chloneda.mapper")
public class MybatisApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MybatisApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }

}
