package com.landkay.springboot.dao;

import com.landkay.springboot.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Description //TODO
 * @param
 * @author landkay
 * @Date 17:05 2018/8/2
 * @return 
 **/
@Repository
public interface UserDao {

    /**
     * Description 根据userId查询userInfo
     * @param userId
     * @author landkay
     * @Date 17:07 2018/8/2
     * @return 
     **/
    public User selectByPrimaryKey(@Param("id") Integer userId);

    /**
     * Description //TODO
     * @param user
     * @author landkay
     * @Date 11:25 2018/8/3
     * @return Integer
     **/
    public Integer insertOne(User user);
}
