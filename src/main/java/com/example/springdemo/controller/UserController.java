package com.example.springdemo.controller;

import com.example.springdemo.general.CommonResult;
import com.example.springdemo.general.sign.Signature;
import com.example.springdemo.pojo.dto.UserParam;
import com.example.springdemo.pojo.dto.UserView;
import com.example.springdemo.pojo.po.User;
import com.example.springdemo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * TestController
 *
 * @Description
 * @Author QianYiyu
 * @Date 2022/07/29 14:55
 */
@Api(tags = "用户接口")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("获取用户信息")
    @PostMapping("/get_user_info")
    public CommonResult<UserView> getUserInfo(@Valid @RequestBody UserParam userParam) {
        UserView userView = userService.getUserView(userParam.getId());

        return CommonResult.success(userView);
    }

    @ApiOperation("GET测试")
    @GetMapping("get_test")
    public CommonResult<Object> getTest(@ApiParam(value = "用户id") @RequestParam("id") Long id) {
        return CommonResult.success("成功", id);
    }

    @ApiOperation("POST测试")
    @PostMapping("post_test")
    public CommonResult<Object> postTest(@RequestBody UserParam param) {
        return CommonResult.success("成功", param.getId());
    }

    @ApiOperation("获取用户信息Restful")
    @GetMapping("users/{ids}")
    public CommonResult<List<UserView>> getUserInfos(@ApiParam("用户id列表") @PathVariable("ids") List<Long> ids) {
        List<UserView> userViews = new ArrayList<>();
        ids.forEach(id -> {
            UserView userView = new UserView(id, "Jack" + id, 24);
            userViews.add(userView);
        });
        return CommonResult.success(userViews);
    }

}
