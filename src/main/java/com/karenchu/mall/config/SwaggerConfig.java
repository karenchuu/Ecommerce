package com.karenchu.mall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger基础配置
 * Created by Karen on 2022/4/26.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 為當前包下controller生成API文檔
                .apis(RequestHandlerSelectors.basePackage("com.karenchu.mall.controller"))
                // 為有@Api註解的Controller生成API文檔
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                // 為有@ApiOperation註解的方法生成API文檔
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("online mall API Document")
                .description("online-mall")
                .version("1.0")
                .build();
    }
}