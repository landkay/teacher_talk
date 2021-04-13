package com.landkay.springboot.controller;

import com.landkay.springboot.biz.UserBiz;
import com.landkay.springboot.constant.ResponseCodeConstant;
import com.landkay.springboot.model.User;
import com.landkay.springboot.model.response.UserInsertResponse;
import com.landkay.springboot.model.response.UserResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
@Api(value = "用户管理模块", tags = "用户管理相关的接口")
/**
 * Description //TODO
 * @param
 * @author landkay
 * @Date 10:37 2018/8/3
 * @return 
 **/
public class UserController {

    @Autowired
    UserBiz userBiz;
    //@Autowired
    //UserFeign userFeign;

    //方法参数说明，name参数名；value参数说明，备注；dataType参数类型；required 是否必传；defaultValue 默认值
    @ApiImplicitParams({@ApiImplicitParam(name = "user", value = "用户信息对象")})
    //说明是什么方法(可以理解为方法注释)
    @ApiOperation(value = "查询用户信息接口", notes = "查询用户信息接口")
    @RequestMapping(value = "/query/userInfo", method = RequestMethod.GET)
    @ResponseBody
    public UserResponse queryUserInfo(@RequestBody User user) {

        UserResponse userResponse = new UserResponse();
        User result = new User();

        //check requestParams
        if (null == user.getId()){
            userResponse.setCode(ResponseCodeConstant.PARAMS_ISNULL.getCode());
            userResponse.setMsg(ResponseCodeConstant.PARAMS_ISNULL.getMsg());
            return userResponse;
        }
        try {
            log.info("请求参数为: requestParams = " + user.getId());
            result = userBiz.queryUserInfo(user.getId());
            userResponse.setCode(ResponseCodeConstant.SUCCESS.getCode());
            userResponse.setMsg(ResponseCodeConstant.SUCCESS.getMsg());
            userResponse.setResult(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            userResponse.setCode(ResponseCodeConstant.ERROR.getCode());
            userResponse.setMsg(ResponseCodeConstant.ERROR.getMsg());
            return userResponse;
        }
        return userResponse;
    }

    /**
     * Description 新增一个用户
     * @param user
     * @author landkay
     * @Date 11:31 2018/8/3
     * @return  UserInsertResponse
     **/
    @PostMapping("/insert/one")
    public UserInsertResponse insertUser(@RequestBody User user){

        UserInsertResponse userInsertResponse = new UserInsertResponse();
        try {
            Integer integer = userBiz.insertOne(user);
            userInsertResponse.setCode(ResponseCodeConstant.SUCCESS.getCode());
            userInsertResponse.setMsg(ResponseCodeConstant.SUCCESS.getMsg());
            userInsertResponse.setResult(integer);
        }catch (Exception e){
            log.error("系统异常: " + e.getMessage());
            userInsertResponse.setCode(ResponseCodeConstant.ERROR.getCode());
            userInsertResponse.setMsg(ResponseCodeConstant.ERROR.getMsg());
            return userInsertResponse;
        }

        return userInsertResponse;
    }


    /*@GetMapping(value = "/query/userInfo/feign")
    public UserResponse queryUserInfoFeign(User user) {

        UserResponse userResponse = new UserResponse();

        //check requestParams
        if (null == user.getId()){
            userResponse.setCode(ResponseCodeConstant.PARAMS_ISNULL.getCode());
            userResponse.setMsg(ResponseCodeConstant.PARAMS_ISNULL.getMsg());
            return userResponse;
        }
        try {
            log.info("请求参数为: requestParams = " + user.getId());
            userResponse = userFeign.queryUserInfo(user);
        } catch (Exception e) {
            log.error(e.getMessage());
            userResponse.setCode(ResponseCodeConstant.ERROR.getCode());
            userResponse.setMsg(ResponseCodeConstant.ERROR.getMsg());
            return userResponse;
        }
        return userResponse;
    }*/
}
