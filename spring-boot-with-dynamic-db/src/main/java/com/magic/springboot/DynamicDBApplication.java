package com.magic.springboot;

import com.magic.springboot.dynamicdbsource.DynamicDataSourceRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({DynamicDataSourceRegister.class})
public class DynamicDBApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicDBApplication.class, args);
    }

}

