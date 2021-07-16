package com.hairui.boot.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger文档配置
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                // 扫描哪个接口的包
                .apis(RequestHandlerSelectors.basePackage("com.hairui.boot.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("标题: 管理系统")
                        .description("详细信息: 后台管理系统接口,详细信息......")
                        // 版本信息
                        .version("1.1")
                        // 开发文档的联系人
                        .contact(new Contact("pjh", "http://www.baidu.com","2123@qq.com"))
                        .license("This Baidu License")
                        .licenseUrl("http://www.baidu.com")
                        .build());
    }
}

