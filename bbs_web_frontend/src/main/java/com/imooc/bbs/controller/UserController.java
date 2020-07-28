package com.imooc.bbs.controller;

import com.imooc.bbs.biz.UserBiz;
import com.imooc.bbs.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.ImageProducer;
import java.util.Map;

@Controller("userController")
public class UserController {

    @Resource
    private UserBiz userBiz;

    @RequestMapping("/preReg")
    public String preReg(Map<String,Object> map){
        map.put("user",new User());
        return "register";
    }
    @RequestMapping("/reg")
    public String reg(HttpServletRequest request, User user,@Param("passwordConfirm") String passwordConfirm){
        if(passwordConfirm.equals(user.getPassword())){
            userBiz.register(user);
            return "redirect:preLogin";
        }else {
            request.setAttribute("msg","密碼不一致");
            return "register";
        }

    }

    @RequestMapping("/preLogin")
    public String preLogin(HttpSession session){
        if(session.getAttribute("user")==null){
            return "login";
        }else {
            return "redirect:list";
        }

    }
    @RequestMapping("/login")
    public String login(HttpSession session,User user){
        User user1 = userBiz.login(user);
        if(user1!=null){
            session.setAttribute("user",user1);
            return "redirect:list";
        }else{
            return "login";
        }
    }
}
