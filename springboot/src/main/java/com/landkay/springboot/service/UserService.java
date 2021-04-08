package com.landkay.springboot.service;

import com.landkay.springboot.model.User;

/**
 * Description //TODO
 * @param
 * @author landkay
 * @Date 17:10 2018/8/2
 * @return 
 **/
public interface UserService {

    /**
     * Description //TODO
     * @param userId
     * @author landkay
     * @Date 17:09 2018/8/2
     * @return 
     **/
    public User selectByPrimaryKey(Integer userId);

    /**
     * Description //TODO
     * @param user
     * @author landkay
     * @Date 11:26 2018/8/3
     * @return Integer
     **/
    public Integer insertOne(User user);
}
