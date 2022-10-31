package com.example.springdemo.service;

import com.example.springdemo.SpringDemoApplication;
import com.example.springdemo.pojo.dto.UserView;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * UserServiceTest
 *
 * @Description
 * @Author QianYiyu
 * @Date 2022/08/27 12:03
 */
@SpringBootTest
class UserServiceTest {
    @BeforeAll
    public static void beforeAll() {
        System.out.println("beforeAll");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("afterAll");
    }

    @Test
    public void test() {
        UserView userView = new UserServiceImpl().getUserView(1L);
        assertEquals(userView.getId(), 1);
        assertEquals(userView.getName(), "Jack1");

        UserServiceImpl userServiceImpl = mock(UserServiceImpl.class);
        when(userServiceImpl.getUserView(anyLong())).thenReturn(new UserView(1L, "Hahaha", 100));
        System.out.println(userServiceImpl.getUserView(1L).getName());
    }
}