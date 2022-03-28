package com.example.demo4.dao;

import com.example.demo4.bean.User;

public interface UserDao {
    //添加用户的接口
    public void addUser(User user) throws Exception;
    public User findUserByNameAndPassword(User user) throws Exception;
}


