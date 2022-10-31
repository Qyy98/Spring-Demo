package com.example.springdemo.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * UserParam
 *
 * @Description
 * @Author QianYiyu
 * @Date 2022/08/26 15:28
 */
@ApiModel(value = "用户请求参数")
@Getter
@Setter
@ToString
public class UserParam {
    @ApiModelProperty(value = "用户id", required = true)
    @Min(1)
    @Max(1000)
    private Long id;
}
