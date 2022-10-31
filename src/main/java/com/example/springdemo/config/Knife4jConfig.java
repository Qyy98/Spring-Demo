package com.example.springdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Knife4jConfig
 *
 * @Description
 * @Author QianYiyu
 * @Date 2022/08/26 15:05
 */
@Configuration
@EnableOpenApi
public class Knife4jConfig {
    @Bean
    public Docket docket() {
        Docket docket = new Docket(DocumentationType.OAS_30)
                .apiInfo(new ApiInfoBuilder()
                        .title("SpringDemo接口文档")
                        .description("SpringDemo测试接口文档")
                        // .termsOfServiceUrl("http://www.xx.com/")
                        .contact(new Contact("Qian Yiyu", "", ""))
                        .version("1.0")
                        .build())
                // 分组名称
                .groupName("Test Group")
                .select()
                // 这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.example.springdemo"))
                .paths(PathSelectors.any())
                .build();

        return docket;
    }
}
