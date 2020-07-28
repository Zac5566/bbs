package com.imooc.bbs.dao;

import com.imooc.bbs.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("commentDao")
public interface CommentDao {
    void insert(Comment comment);
    List<Comment> selectAll();
    List<Comment> selectByPostId(Long postId);
}
