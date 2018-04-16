package com.lxj.manage.controller;

import com.lxj.manage.bean.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lxj
 *
 * 用于对页面进行操作的controller
 * */
@Controller
public class AuthorityController {

    @RequestMapping("/")
    public String index(Model model){
        Msg msg =  new Msg("测试标题","测试内容","欢迎来到HOME页面,您拥有 ROLE_HOME 权限");
        model.addAttribute("msg", msg);
        return "home";
    }
    @RequestMapping("/login")
    public  String login(){
        return "login";
    }
    @RequestMapping("/admin")
    @ResponseBody
    public String hello(){
        return "hello admin";
    }
}
