package com.zcy.javareview.service.impl;

import com.zcy.javareview.dao.UserMapper;
import com.zcy.javareview.entity.User;
import com.zcy.javareview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zcy
 * @version 1.0.0
 * @date 2023/3/21 10:58
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUser(Integer  id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insert(user);
    }
}
