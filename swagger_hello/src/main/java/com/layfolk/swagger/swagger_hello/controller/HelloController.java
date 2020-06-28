package com.layfolk.swagger.swagger_hello.controller;


import com.layfolk.swagger.swagger_hello.dao.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 王津
 * @Date 2020/6/28
 * @Version 1.0
 */
@RestController
public class HelloController {


    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/getUser")
    public User getUser(User user){
        return user;
    }

    @ApiOperation("wj的接口")
    @PostMapping("/layfolk")
    public String layfolk(@ApiParam("这个名字会被返回")String username){
        return username;
    }
}
