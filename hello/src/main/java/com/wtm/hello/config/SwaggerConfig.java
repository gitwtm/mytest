package com.wtm.hello.config;

import com.wtm.hello.controller.HelloController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.env.EnvScalarConstructor;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.nio.file.Path;
import java.util.ArrayList;

@Configuration
@EnableSwagger2 //开启swagger2
public class SwaggerConfig {
    //配置了swagger的Docket的bean实列
     @Bean
    public Docket docket(Environment environment){
         //设置要显示的Swagger环境因为
         Profiles profiles=Profiles.of("dev");
         //通过environment.acceptsProfiles判断是否处在自己设定的环境当中
         boolean flag = environment.acceptsProfiles(profiles);
         return   new Docket(DocumentationType.SWAGGER_2)
              .apiInfo(apiInfo())
              .groupName("hello")
              .enable(true) //enable是否启动Swagger 如果为False，则swagger不能在浏览器中访问
              .select()
              //RequestHandlerSelectors 配置要扫描接口的方式
              //basePackage：指定扫描的包
              //any():扫描全部
              //none():不扫描
              //withClassAnnotation:扫描类上的注解,参数是一个注解的反射对象
              //withMethodAnnotation:扫描方法上的注解
              .apis(RequestHandlerSelectors.basePackage("com.wtm.hello.controller"))
              //paths().过滤什么路径
              //.paths(PathSelectors.ant("/wtm/**"))
              .build();
    }
    //配置swagger信息=apiInfo
    private ApiInfo apiInfo(){
         //作者信息
        Contact contact = new Contact("wtm", "https://www.baidu.com/", "2916438270@qq.com");
        return new ApiInfo(
                "wtmSwaggerApi文档",
                "即使再小的帆也能远航",
                "v1.o",
                "https://www.baidu.com/",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }
}