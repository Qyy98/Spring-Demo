package com.example.springdemo.service;

import com.example.springdemo.pojo.dto.UserView;

/**
 * UserService
 *
 * @Description
 * @Author QianYiyu
 * @Date 2022/08/26 15:30
 */
public interface UserService {
    UserView getUserView(Long id);

}
