package com.github.ybqdren.mybatisDemo.dao;

import com.github.ybqdren.mybatisDemo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <h1>  </h1>
 *
 * @Author zhao wen
 * @Version 0.0.1
 * @Date 2022/3/4
 **/


@Mapper
public interface UserMapper {
    public List<User> queryUserBySchoolName(User user);
}
