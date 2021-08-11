package com.wtm.hello.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
//@Api("注释")
@ApiModel("用户实体类")
public class User {
    @ApiModelProperty("用户名字")
    private String username;
    @ApiModelProperty("用户密码")
    private String password;
}
