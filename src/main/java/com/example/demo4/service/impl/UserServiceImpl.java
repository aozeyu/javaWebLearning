package com.example.demo4.service.impl;

import com.example.demo4.bean.User;
import com.example.demo4.dao.UserDao;
import com.example.demo4.dao.impl.UserDaoImpl;
import com.example.demo4.service.UserService;

public class UserServiceImpl implements UserService {
    //多态
    UserDao userDao = new UserDaoImpl();
    @Override
    public void addUser(User user) throws Exception {
        userDao.addUser(user);
    }

    @Override
    public User findUserByNameAndPassword(User user) throws Exception {
        return userDao.findUserByNameAndPassword(user);
    }
}
