package com.imooc.bbs.controller;

import com.github.pagehelper.PageInfo;
import com.imooc.bbs.biz.CommentBiz;
import com.imooc.bbs.biz.PostBiz;
import com.imooc.bbs.biz.UserBiz;
import com.imooc.bbs.dao.CommentDao;
import com.imooc.bbs.entity.Comment;
import com.imooc.bbs.entity.Post;
import com.imooc.bbs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/*
* 功能
*   -顯示所有貼文
*   -顯示單個貼文+留言內容
*   -發文
*   -留言
* */
@Controller("forumController")
public class ForumController {

    @Resource
    private PostBiz postBiz;
    @Resource
    private CommentBiz commentBiz;

    @Resource
    private UserBiz userBiz;

    @RequestMapping("/list")
    public String list(Integer page,Map<String,Object> map){
        if(page==null)page=1;
        PageInfo<Post> postList = postBiz.page(page);
        map.put("postList",postList);
        return "list";
    }
    @RequestMapping("/getPost")
    public String getPost(Integer page,Long id,Map<String,Object> map){
        if(page==null) page=1;
        Post post = postBiz.selectById(id);
        PageInfo<Comment> commentList = commentBiz.pages(page, id);
        //該篇文章
        map.put("post",post);
        //該文章的comment
        map.put("commentList",commentList);
        Comment comment = new Comment();
        comment.setPostId(id);
        //給前台comment對象，用來接收可能的comment
        map.put("comment",comment);
        return "post";
    }
    @RequestMapping("/prePost")
    public String prePost(HttpSession session,Map<String,Object> map){
        if(session.getAttribute("user")!=null){
            map.put("post",new Post());
            return "newpost";
        }else{
            return "redirect:preLogin";
        }
    }
    @RequestMapping("/post")
    public String post(HttpSession session,Post post){
        User user = (User) session.getAttribute("user");
        boolean locked = userBiz.isLocked(user.getId());
        //判斷是否被鎖，是則不能發文
        if(locked){
            //取得user最新的狀態
            session.setAttribute("user",userBiz.selectOne(user.getId()));
           return "redirect:locked";
        }else{
            post.setUsername(user.getUsername());
            if(user!=null){
                postBiz.post(post);
                return "redirect:list";
            }else{
                return "redirect:preLogin";
            }
        }
    }
    @RequestMapping("/replyPost")
    public String replyPost(HttpSession session,Comment comment){
        User user = (User) session.getAttribute("user");
        boolean locked = userBiz.isLocked(user.getId());
        //判斷是否被鎖，是則不能發文
        if(locked){
            return "redirect:locked";
        }else {
            if (user != null) {
                comment.setUserId(user.getId());
                comment.setUsername(user.getUsername());
                commentBiz.insert(comment);
                return "redirect:getPost?id=" + comment.getPostId();
            } else {
                return "redirect:preLogin";
            }
        }
    }
    @ResponseBody
    @RequestMapping("/locked")
    public String locked(){
        return "<h1 style='color:red'>該用戶已被鎖定，無法發文</h1>";
    }
}
