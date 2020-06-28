package com.layfolk.swagger.swagger_hello.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @Author 王津
 * @Date 2020/6/28
 * @Version 1.0
 */

@Configuration//配置类
@EnableSwagger2//开启swagger2的配置
public class SwaggerConfig {


    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("group1");
    }

    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("group2");
    }

    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("group3");
    }

    @Bean//配置docket以配置Swagger具体参数
    public Docket docket(Environment environment){
        //设置要显示的swagger环境
        Profiles profiles = Profiles.of("dev","test");
        //通过environment.acceptsProfiles判断是否处在自己设定的h环境当中
        boolean flag = environment.acceptsProfiles(profiles);
        System.out.println(flag);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("王津")
                .enable(flag)//enable是否启动swagger，false就不启动了。。一般开发环境启动。
                .select()
                //RequestHandlerSelectors,配置要扫描接口的方式
                //basePackage:指定要扫描的包
                //any():扫描全部
                //none():不扫描
                //withClassAnnotation:扫描类上的注解，参数是一个注解的反射对象
                //withMethodAnnotation:扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.layfolk.swagger.swagger_hello.controller"))
                //paths()  //过滤什么路径
                //.paths(PathSelectors.ant("/layfolk/**"))
                .build();
    }

    //配置文档信息
    private ApiInfo apiInfo(){
         Contact contact = new Contact("联系人姓名", "http://www.wj.com", "wangjin_java@foxmail.com");
        return new ApiInfo(
                "swagger学习",//标题
                "学习如何配置swagger",//描述
                "VV1.0",//版本
                "http://www.wj.com",//组织连接
                contact,//联系人信息
                "Apache 2.0 许可",//许可
                "www.wj.com",//许可连接
                new ArrayList<>());//扩展
    }
}
