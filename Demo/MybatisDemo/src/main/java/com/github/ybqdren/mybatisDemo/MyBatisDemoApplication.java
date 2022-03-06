package com.github.ybqdren.mybatisDemo;

import com.github.ybqdren.mybatisDemo.pojo.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>  </h1>
 *
 * @Author zhao wen
 * @Version 0.0.1
 * @Date 2022/3/4
 **/

@SpringBootApplication
public class MyBatisDemoApplication {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        String url = "jdbc:mysql://127.0.0.1:3306/mybatis_test?serverTimezone=UTC";
//        String userName = "root";
//        String password = "666666";
//
//        User userParam = new User();
//        userParam.setSchoolName("Sunny School");
//
//        // 第一步：加载驱动程序
//        Class.forName("com.mysql.jdbc.Driver");
//
//        // 第二步：获得数据库的连接
//        Connection conn = DriverManager.getConnection(url, userName, password);
//
//        // 第三步：创建语句并执行
//        Statement stmt = conn.createStatement();
//        ResultSet resultSet = stmt.executeQuery("SELECT * FROM `user` WHERE schoolName = \'" + userParam.getSchoolName() + "\';");
//
//        // 第四步：处理数据库操作结果
//        List<User> userList = new ArrayList<>();
//        while(resultSet.next()){
//            User user = new User();
//            user.setId(resultSet.getInt("id"));
//            user.setName(resultSet.getString("name"));
//            user.setEmail(resultSet.getString("email"));
//            user.setAge(resultSet.getInt("age"));
//            user.setSex(resultSet.getInt("sex"));
//            user.setSchoolName(resultSet.getString("schoolName"));
//            userList.add(user);
//        }
//
//        // 第五步：关闭连接
//        stmt.close();
//
//        for (User user : userList) {
//            System.out.println("name : " + user.getName() + " ;  email : " + user.getEmail());
//        }
        SpringApplication.run(MyBatisDemoApplication.class);
    }
}
