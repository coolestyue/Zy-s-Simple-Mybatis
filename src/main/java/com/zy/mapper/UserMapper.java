package com.zy.mapper;

import com.zy.mybatis.annotation.Select;
import com.zy.pojo.User;

import java.util.List;

/**
 * ZY
 * 19:12
 */
public interface UserMapper {
    @Select("SELECT * FROM user")
    List<User> selectList();
}
