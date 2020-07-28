package com.imooc.bbs.biz;

import com.github.pagehelper.PageInfo;
import com.imooc.bbs.entity.Comment;
import com.imooc.bbs.entity.Post;

import java.util.List;

public interface PostBiz {
    void post(Post post);
    void delete(Long id);
    Post selectById(Long id);
    List<Post> selectAll();
    List<Post> selectByTag(String tag);
    PageInfo<Post> page(int currentPage);
}
