package com.chloneda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chloneda
 * @description:
 */
@SpringBootApplication(scanBasePackages = {"com.chloneda"})
public class PackageApplication {

    public static void main(String[] args) {
        SpringApplication.run(PackageApplication.class,args);
    }

}
