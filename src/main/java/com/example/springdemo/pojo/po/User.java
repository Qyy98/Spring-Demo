package com.example.springdemo.pojo.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * User
 *
 * @Description
 * @Author QianYiyu
 * @Date 2022/08/25 18:57
 */
@ApiModel(value = "用户", description = "用户的实体类")
@Getter
@Setter
public class User {
    @ApiModelProperty(value = "用户id", required = true)
    private Long id;

    @ApiModelProperty(value = "用户名", required = true)
    private  String name;
}
