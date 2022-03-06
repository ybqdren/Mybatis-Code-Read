package com.github.ybqdren;

import com.github.ybqdren.dao.UserMapper;
import com.github.ybqdren.pojo.User;
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

        /**
         使用 Mybatis 完成数据库的查询操作，在改配置下，Mybatis完成了下面的映射关系：
         - 映射文件中的 SQL 语句与映射接口中的抽象方法建立了映射
         SQL语句“SELECT*FROM`user`WHERE schoolName=＃{schoolName}”对应了
         “List＜User＞queryUserBySchoolName（User user）”方法。
         - SQL 语句的输入参数与方法输入参数建立了映射。
         SQL 语句中的“＃{schoolName}”参数对应了方法输入参数User对象的 schoolName属性。
         - SQL语句的输出结果与方法结果建立了映射
         SQL语句的输出结果对应了User对象。
         */
        List<User> userList = userMapper.queryUserBySchoolName(userParam);

        for (User user : userList) {
            System.out.println("name" + user.getName() + "; email:" + user.getEmail());
        }
        return userList;
    }
}
