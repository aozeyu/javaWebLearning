package com.example.demo4.service;

import com.example.demo4.bean.User;

public interface UserService {
    public void addUser(User user) throws Exception;
    public User findUserByNameAndPassword(User user) throws Exception;
}
