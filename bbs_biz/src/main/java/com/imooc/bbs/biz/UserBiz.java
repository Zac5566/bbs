package com.imooc.bbs.biz;

import com.imooc.bbs.entity.User;

import java.util.List;

public interface UserBiz {
    void register(User user);
    User login(User user);
    void delete(Long id);
    void lock(Long id);
    void unlock(Long id);
    User selectOne(Long id);
    List<User> selectAll();
    boolean isLocked(Long id);
}
