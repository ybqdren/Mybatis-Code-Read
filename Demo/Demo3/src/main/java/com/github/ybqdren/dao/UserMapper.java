package com.github.ybqdren.dao;

import com.github.ybqdren.pojo.User;
import org.apache.ibatis.annotations.Mapper;

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
