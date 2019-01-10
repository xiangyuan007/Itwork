package com.work.Controller;
import com.work.Entity.Administrator;
import com.work.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/adminWeb")
public class adminPageController {
    Administrator admin = new Administrator();
    @Autowired
    private AdminService adminService;
    //登录Controller
    @RequestMapping("/adminlogin")
    public String login( @RequestParam String name,String password, Model m,  HttpSession session){
        Object usero = session.getAttribute("admin");
        //如果用户登陆过直接进入用户主页
        if(usero!=null){
            return "index";
        }

        admin.setAdminName(name);
        admin.setAdminPassword(password);

        //判断是否存在该用户
        int issu =  adminService.hasAdmin(name,password);
        if (issu==1){          //登录成功
            return "index";
        }else if(issu==2){      //密码错误
            m.addAttribute("name","1");
            return "login";
        }else {                 //不存在该用户
            m.addAttribute("name","2");
            return "login";
        }
    }

    //跳转到登录页面
    @GetMapping(value = "/login")
    public String indexpage(String name,Model model){
        model.addAttribute("name",name);
        return  "login";
    }
}