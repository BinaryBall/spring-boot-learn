package com.jamal.springbootswagger.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger 配置类
 */
@EnableSwagger2
@Configuration
//@Profile({"dev","test"})
@ConditionalOnProperty(name = "swagger.enable",havingValue = "true")
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 扫描的包
                .apis(RequestHandlerSelectors.basePackage("com.jamal.springbootswagger.controller"))
                // 选择API路径
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // swagger ui 的标题
                .title("Spring Boot中使用 Swagger2 构建 Restful APIs")
                // 描述
                .description("更多信息关注公众号 平头哥的技术博文")
                // 外链
                .termsOfServiceUrl("https://www.jianshu.com/u/008ce054774c")
                // 文档的版本信息
                .version("1.0")
                .build();
    }
}
