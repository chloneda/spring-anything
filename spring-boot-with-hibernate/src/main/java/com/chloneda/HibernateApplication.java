package com.chloneda;

import com.chloneda.config.AppConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ImportAutoConfiguration
@Import({AppConfiguration.class})
@EnableTransactionManagement
public class HibernateApplication extends SpringBootServletInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HibernateApplication.class);
    }

    public static void main(String[] args)  {
        SpringApplication.run(HibernateApplication.class, args);
    }

}
