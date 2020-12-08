package com.ebupt.cu.config.swagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @ClassName Swagger2Config
 * @Description
 * @Author Leipei
 * @Date 2020/11/25 16:41
 * @Version V1.0
 **/
@Configuration
@EnableSwagger2
public class Swagger2Config {
    //配置了swagger的Docket的bean实力
    @Bean
    public Docket docket(Environment environment) {

        //设置要显示的swagger环境，生产环境pro不开启
        Profiles profiles = Profiles.of("dev", "test");
        //表示当前应用程序正在其中运行的环境
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                // enable()表示是否启动swagger
                .enable(flag)
                // groupName 设置分组，如果要设置多个分组；配置多个Docket实例即可
                .groupName("UncleRay")
                .select()
                //RequestHandlerSelectors，配置要扫描接口的方式
                //basePackage:指定要扫描的包
                //any():扫描全部
                //none()：不扫描
                //withClassAnnotation：扫描类上的注解，参数是一个注解的反射对象
                //withMethodAnnotation：扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.ebupt.cu.web.controller"))
                //paths()：过滤什么路径
                .paths(PathSelectors.any())
                .build();
    }

    // 配置swagger信息=apiInfo
    private ApiInfo apiInfo() {
        // 作者信息
        Contact contact = new Contact("leipei", "http://www.baidu.com", "uncleray@email.com");
        return new ApiInfo(
                "UncleRay的Swagger API文档",
                "即使再小的帆也能远航",
                "v1.0",
                "http://www.baidu.com",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }
}
