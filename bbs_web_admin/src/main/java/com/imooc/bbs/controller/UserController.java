package com.imooc.bbs.controller;


import com.imooc.bbs.biz.UserBiz;
import com.imooc.bbs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
/*
* 功能
*   -顯示所有用戶
*   -用戶狀態
*   -帖子相關
*
* */
@Controller("userController")
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserBiz userBiz;

    @RequestMapping("/list")
    public String list(Map<String,Object> map){
        List<User> users = userBiz.selectAll();
        map.put("userList",users);
        return "users";
   }
   //用戶狀態

   @RequestMapping("/lock")
    public String lock(Long id){
        userBiz.lock(id);
        return "redirect:list";
   }
   @RequestMapping("/remove")
    public String remove(Long id){
        userBiz.delete(id);
        return "redirect:list";
   }
    @RequestMapping("/unlock")
    public String unlock(Long id){
        userBiz.unlock(id);
        return "redirect:list";
    }
}
