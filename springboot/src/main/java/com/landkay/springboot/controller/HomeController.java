package com.landkay.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author landkay
 * @Title: HomeController
 * @ProjectName myspringboot
 * @Description: TODO
 * @date 2018/12/2714:08
 */
@Controller
public class HomeController {


    /**
     * Description 跳转到主页
     * @param
     * @author landkay
     * @Date 14:16 2018/12/27
     * @return
     **/
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String homePage(){
        return "/home.html";
    }
}
