package com.landkay.springboot.service.impl;

import com.landkay.springboot.dao.UserMapper;
import com.landkay.springboot.model.User;
import com.landkay.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 90818
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userDao;

    @Override
    public User selectByPrimaryKey(Integer userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    @Override
    public Integer insertOne(User user) {
        return userDao.insertOne(user);
    }
}
