package com.wtm.hello.controller;

import com.wtm.hello.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    //只要我们的接口中，返回值中存在实体类他就会被扫描到swagger中
    @PostMapping ("/user")
    public User user(){
        return  new User();
    }
    //接口注释不是放在类上的是方法。
    @ApiOperation("hello接口")
    @GetMapping("/hello2")
    public String hello2(@ApiParam("用户名") String username){
        return "hello"+username;
    }
    @ApiOperation("Post测试接口")
    @PostMapping("/postt")
    public String postt(String username,String password){
        return username+password;
    }
}
