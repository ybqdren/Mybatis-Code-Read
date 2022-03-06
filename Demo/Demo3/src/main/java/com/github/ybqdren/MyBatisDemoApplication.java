package com.github.ybqdren;


import com.github.ybqdren.dao.UserMapper;
import com.github.ybqdren.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
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

        // 第一阶段：MyBatis 初始化阶段
        String resource = "mybatis-config.xml";

        // 得到配置文件的输入流
        InputStream inputStream = null;
        try {
            // 讲配置文件的路径传递给了 Resource 中的 getResourceAsStream 方法
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 得到 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 第二阶段：数据读写阶段
        // 有一点需要注意，数据读写阶段是在进行数据读写时触发的，
        // 但并不是每次读写都会触发“SqlSession session=sqlSessionFactory.openSession()”操作，
        // 因为该操作得到的SqlSession对象可以供多次数据库读写操作复用。
        try (SqlSession session = sqlSessionFactory.openSession()) {
            // 找到接口对应的实现
            UserMapper userMapper = session.getMapper(UserMapper.class);

            // 组建查询参数
            User userParam = new User();
            userParam.setSchoolName("Sunny School");
            //调用接口展开数据库操作
            List<User> userList = userMapper.queryUserBySchoolName(userParam);
            // 打印查询结果
            for (User user : userList) {
                System.out.println("name: " + user.getName() + "; email" + user.getEmail());
            }
        }
    }
}
