package com.imooc.bbs.controller;

import com.imooc.bbs.biz.PostBiz;
import com.imooc.bbs.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/*
* 功能
*   -顯示所有發文
*   -刪帖
*
* */
@Controller("postController")
@RequestMapping("/post")
public class PostController {

    @Resource
    private PostBiz postBiz;

    @RequestMapping("/list")
    public String list(Map<String,Object> map){
        List<Post> postList = postBiz.selectAll();
        map.put("postList",postList);
        return "posts";
    }

    @RequestMapping("/remove")
    public String remove(Long id){
        postBiz.delete(id);
        return "redirect:list";
    }
}
