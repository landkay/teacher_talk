package com.landkay.springboot.biz.impl;

import com.landkay.springboot.biz.UserBiz;
import com.landkay.springboot.model.User;
import com.landkay.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description //TODO
 * @param
 * @author landkay
 * @Date 17:12 2018/8/2
 * @return 
 **/
@Service
//@Transactional(readOnly = true, rollbackFor = Exception.class)
public class UserBizImpl implements UserBiz {

    @Autowired
    UserService userService;

    @Override
    public User queryUserInfo(Integer userId) {

        User user = userService.selectByPrimaryKey(userId);

        User userInfo = new User();
        userInfo.setUserName("吕布无敌");
        userInfo.setAge("28");
        return user;
    }

    @Override
    /**
     * Description
     * 注意：方法的@Transactional会覆盖类上面声明的事务
     * Propagation.REQUIRED ：有事务就处于当前事务中，没事务就创建一个事务
     * isolation=Isolation.DEFAULT：事务数据库的默认隔离级别
     * @param [user]
     * @author landkay
     * @Date 12:13 2018/8/3
     * @return java.lang.Integer
     **/
    //@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
    public Integer insertOne(User user) {

        Integer integer = userService.insertOne(user);
        // int i = 1 / 0;   仅用来测试事物是否成功
        return integer;
    }
}
