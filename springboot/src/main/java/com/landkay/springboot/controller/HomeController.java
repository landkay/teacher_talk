package com.landkay.springboot.controller;

import com.landkay.springboot.entity.LoginLog;
import com.landkay.springboot.model.response.R;
import com.landkay.springboot.service.ILoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;

/**
 * @author landkay
 * @Title: HomeController
 * @ProjectName myspringboot
 * @Description: TODO
 * @date 2018/12/2714:08
 */
@Controller
@CrossOrigin(origins = {"http://127.0.0.1"}, maxAge = 30000)
public class HomeController {

    @Autowired
    private ILoginLogService iLoginLogService;

    /**
     * Description 跳转到主页
     *
     * @param
     * @return
     * @author landkay
     * @Date 14:16 2018/12/27
     **/
    @RequestMapping(value = "/ips/home", method = RequestMethod.GET)
    public String homePage() {

        return "/home.html";
    }

    @ResponseBody
    @RequestMapping(value = "/ips/home", method = RequestMethod.POST)
    public R homePage(HttpServletRequest request) {

        return R.success(new HashMap<>());
    }

    @ResponseBody
    @RequestMapping(value = "/ips/saveLoginLog", method = RequestMethod.POST)
    public R saveLoginLog() {

        LoginLog loginLog = new LoginLog();
        loginLog.setUserCode("02058985");
        loginLog.setUserName("廉惠民");
        iLoginLogService.save(loginLog);
        return R.success(null);
    }

}
