package com.imooc.bbs.dao;

import com.imooc.bbs.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("postDao")
public interface PostDao {
    void insert(Post post);
    void delete(Long id);
    Post selectById(Long id);
    List<Post> selectAll();
    List<Post> selectByTag(String tag);
}
