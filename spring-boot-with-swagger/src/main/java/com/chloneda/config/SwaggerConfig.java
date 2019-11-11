package com.chloneda.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static com.google.common.base.Predicates.not;
import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author chloneda
 * @description: Swagger访问路径：http://IP:port/swagger-ui.html
 */
@EnableSwagger2
@Configuration
@ComponentScan(basePackages = {"com.chloneda"})
public class SwaggerConfig {

    @Bean
    public Docket magicLampApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")// base，最终调用接口后会和paths拼接在一起
                .select()
//                .paths(or(regex("/api/.*")))//过滤的接口
                .paths(paths()).paths(not(regex("/configprops.*")))
                .build()
                .apiInfo(magicSpringBootApiInfo());
    }

    private Predicate<String> paths() {
        return or(
                /**
                 * 接口可见
                 */
                regex("/user.*")
        );
    }

    private ApiInfo magicSpringBootApiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Spring-Anything API",//大标题
                "Spring-Anything API doc.",//小标题
                "V0.0.3",//版本
                "NO terms of service",
                new Contact("Chloneda", "", ""),//作者
                "The Apache License, Version 2.0",//链接显示文字
                "http://www.apache.org/licenses/LICENSE-2.0.html"//网站链接
                , new ArrayList<>());
        return apiInfo;
    }

}
