package com.imooc.bbs.biz.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imooc.bbs.biz.PostBiz;
import com.imooc.bbs.dao.PostDao;
import com.imooc.bbs.entity.Post;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("postBiz")
public class PostBizImpl implements PostBiz {

    @Resource
    private PostDao postDao;

    public void post(Post post) {
        post.setCreateTime(new Date());
        postDao.insert(post);
    }

    public void delete(Long id) {
        postDao.delete(id);
    }

    public Post selectById(Long id) {
        return postDao.selectById(id);
    }

    public List<Post> selectAll() {
        return postDao.selectAll();
    }

    public List<Post> selectByTag(String tag) {
        return postDao.selectByTag(tag);
    }

    public PageInfo<Post> page(int currentPage) {
        PageHelper.startPage(currentPage,10);
        List<Post> list = postDao.selectAll();
        PageInfo<Post> pageInfo = new PageInfo<Post>(list);
        return pageInfo;
    }
}
