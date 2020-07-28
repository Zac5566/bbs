package com.imooc.bbs.biz.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imooc.bbs.biz.CommentBiz;
import com.imooc.bbs.dao.CommentDao;
import com.imooc.bbs.entity.Comment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("commentBiz")
public class CommentBizImpl implements CommentBiz {

    @Resource
    private CommentDao commentDao;

    public void insert(Comment comment) {
        comment.setCreateTime(new Date());
        commentDao.insert(comment);
    }

    public List<Comment> selectAll() {
        return commentDao.selectAll();
    }

    public List<Comment> selectByPostId(Long postId) {
        return commentDao.selectByPostId(postId);
    }

    public PageInfo<Comment> pages(int page,Long postId) {
        PageHelper.startPage(page,10);
        List<Comment> list = commentDao.selectByPostId(postId);
        PageInfo<Comment> pageInfo = new PageInfo<Comment>(list);
        return pageInfo;
    }
}
