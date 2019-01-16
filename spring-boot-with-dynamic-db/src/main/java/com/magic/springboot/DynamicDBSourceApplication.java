package com.magic.springboot;

import com.magic.springboot.dynamicdbsource.DynamicDataSourceRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@ImportAutoConfiguration
@Import({DynamicDataSourceRegister.class})
public class DynamicDBSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicDBSourceApplication.class, args);
    }

}

