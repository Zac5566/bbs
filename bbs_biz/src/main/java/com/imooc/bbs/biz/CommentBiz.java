package com.imooc.bbs.biz;

import com.github.pagehelper.PageInfo;
import com.imooc.bbs.entity.Comment;

import java.util.List;

public interface CommentBiz {
    void insert(Comment comment);
    List<Comment> selectAll();
    List<Comment> selectByPostId(Long postId);
    PageInfo<Comment> pages(int page,Long postId);
}
