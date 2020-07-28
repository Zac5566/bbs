package com.imooc.bbs.dao;

import com.imooc.bbs.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public interface UserDao {
    void insert(User user);
    void delete(Long id);
    void update(User user);
    User selectOne(Long id);
    User selectByNameAndPassword(User user);
    List<User> selectAll();

}
