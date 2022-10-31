package com.example.springdemo.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * UserView
 *
 * @Description
 * @Author QianYiyu
 * @Date 2022/08/26 15:31
 */
@ApiModel(value = "用户视图")
@Getter
@Setter
@AllArgsConstructor
public class UserView {
    @ApiModelProperty(value = "用户id", required = true)
    private Long id;

    @ApiModelProperty(value = "用户名", required = true)
    private String name;

    @ApiModelProperty(value = "用户年龄", required = true)
    private Integer age;
}