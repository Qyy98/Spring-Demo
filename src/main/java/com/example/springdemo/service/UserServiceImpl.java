package com.example.springdemo.service;

import com.example.springdemo.pojo.dto.UserView;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 *
 * @Description
 * @Author QianYiyu
 * @Date 2022/08/26 15:33
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserView getUserView(Long id) {
        return new UserView(id, "Jack"+id, 24);
    }
}

