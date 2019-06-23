package com.hx5847.config;

import com.hx5847.beans.Announcement;
import com.hx5847.beans.Usersmessage;
import com.hx5847.dao.AnnouncementMapper;
import com.hx5847.dao.UserMapper;
import com.hx5847.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class testUser {
    private ApplicationContext applicationContext=new AnnotationConfigApplicationContext(ConfigIOC.class);

    @Test
    public void testGetUserIntrestById(){
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);
        List<String> userIntrestById = userMapper.getUserIntrestById(7);
        System.out.println(userIntrestById);


    }
    @Test
    public void testGetUserNameById(){
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);
        String s= userMapper.getUserNameById(2);
        System.out.println(s);


    }
    @Test
    public void TestGetUserRecommendById(){
        UserService userService = applicationContext.getBean(UserService.class);
        Map<String, Object> userRecommendById = userService.getUserRecommendById(2);
        System.out.println(userRecommendById);

    }
    @Test
    public void getUserIntrestBooks(){
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);
        List<String> strings =new ArrayList<String>();
        strings.add("科幻");
//        userMapper.getUserIntrestBooks(strings);

    }
    @Test
    public void generateUserRecommendById(){
        UserService userService = applicationContext.getBean(UserService.class);

        String s = userService.generateUserRecommendById(4);
        System.out.println(s);

    }
}