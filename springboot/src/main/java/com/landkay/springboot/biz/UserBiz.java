package com.landkay.springboot.biz;

import com.landkay.springboot.model.User;

/**
 * Description //TODO
 * @param
 * @author landkay
 * @Date 17:12 2018/8/2
 * @return 
 **/
public interface UserBiz {

    /**
     * query userInfo by id
     * @return
     * @param userId
     */
    User queryUserInfo(Integer userId);

    /**
     * Description //TODO
     * @param user
     * @author landkay
     * @Date 11:28 2018/8/3
     * @return Integer
     **/
    Integer insertOne(User user);
}
