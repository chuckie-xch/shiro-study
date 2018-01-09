package com.bestcode.study.shiro.service;

import com.bestcode.study.shiro.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author xch
 * @create 2018-01-07 22:36
 **/
public interface UserService {

    User findByUsername(@Param("username") String username);
}
