package com.bestcode.study.shiro.mapper;

import com.bestcode.study.shiro.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author xch
 * @create 2018-01-07 22:34
 **/
public interface UserMapper {

    User findByUsername(@Param("username") String username);
}
