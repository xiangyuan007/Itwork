package com.work.Controller;

import com.work.Entity.User;
import com.work.service.UserService;
import com.work.serviceImpl.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RestController
@RequestMapping("wx")
public class WxController {
    //@Autowired
    //HttpClient httpClient;
    @Autowired
    private UserService userService;
    @PostMapping("/wxLogin")
    public String wxLogin( @RequestParam String openid,String identity){
        String success1="用户初次登录成功";
        String success2="用户登录成功";
        /*System.out.println("wxLogin-code:"+code);
        String url="https://api.weixin.qq.com/sns/jscode2session";
        HttpMethod method =HttpMethod.POST;
        MultiValueMap<String, String> param= new LinkedMultiValueMap<String, String>();
        param.add("appid","wxa4958450998eb776");
        param.add("secret","625211eb2ee7a1390784bc941b263cbd");
        param.add("js_code",code);
        param.add("grant_type","authorization_code");
        String data = httpClient.client(url,method,param);
        System.out.println(data);
        return success;*/
        User user=new User();
        user=userService.findOne(openid);
        if(user!=null)
            return success2;
        else{
            User tmp=new User();
            tmp.setUserName(openid);
            tmp.setIdentity(identity);
            userService.addUser(tmp);
        }
        return success1;
    }
}
