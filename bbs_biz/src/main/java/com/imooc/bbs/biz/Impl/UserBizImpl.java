package com.imooc.bbs.biz.Impl;

import com.imooc.bbs.biz.UserBiz;
import com.imooc.bbs.dao.UserDao;
import com.imooc.bbs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userBiz")
public class UserBizImpl implements UserBiz {

    @Resource
    private UserDao userDao;

    public void insert(User user) {
        userDao.insert(user);
    }

    public void register(User user) {
        user.setUserStatus(0);
        userDao.insert(user);
    }

    public User login(User user) {
        User user1 = userDao.selectByNameAndPassword(user);
        if(user1==null){
            return null;
        }else if(user1.getUserStatus()==2){
            //用戶被刪除就返回空
            return null;
        }
        return user1;
    }

    public void delete(Long id) {
        changeStatus(id);
    }

    public void lock(Long id) {
        changeStatus(id);
    }
    public void unlock(Long id) {
        changeStatus(id);
    }
    public User selectOne(Long id) {
        return userDao.selectOne(id);
    }
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    public boolean isLocked(Long id) {
        User user = userDao.selectOne(id);
        if(user.getUserStatus().equals(0)){
            return false;
        }
        else{
            return true;
        }
    }

    private void changeStatus(Long id){
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        User user = userDao.selectOne(id);
        if("unlock".equals(methodName)){
            user.setUserStatus(0);
        }else if("lock".equals(methodName)){
            user.setUserStatus(1);
        }else if("delete".equals(methodName)) {
            user.setUserStatus(2);
        }
        userDao.update(user);
    }
}
