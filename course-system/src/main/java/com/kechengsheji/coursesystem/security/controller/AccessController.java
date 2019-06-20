package com.kechengsheji.coursesystem.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/access")
public class AccessController {

    @RequestMapping("login")
    public String login(){

        return  null;
    }

    @RequestMapping("userInfo")
    public  String userInfo(){

        return  null;
    }

    @RequestMapping("changePwd")
    public String changePassword(){
        return  null;
    }
}
