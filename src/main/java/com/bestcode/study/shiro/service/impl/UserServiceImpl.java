package com.bestcode.study.shiro.service.impl;

import com.bestcode.study.shiro.mapper.UserMapper;
import com.bestcode.study.shiro.model.User;
import com.bestcode.study.shiro.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xch
 * @create 2018-01-07 22:36
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
