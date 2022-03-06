package com.github.ybqdren.mybatisDemo.controller;

import com.github.ybqdren.mybatisDemo.dao.UserMapper;
import com.github.ybqdren.mybatisDemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <h1>  </h1>
 *
 * @Author zhao wen
 * @Version 0.0.1
 * @Date 2022/3/4
 **/


@RestController
@RequestMapping
public class MainContoller {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/")
    public Object index() {
        User userParam = new User();
        userParam.setSchoolName("Sunny School");
        List<User> userList = userMapper.queryUserBySchoolName(userParam);
        for (User user : userList) {
            System.out.println("name" + user.getName() + "; email:" + user.getEmail());
        }
        return userList;
    }
}
