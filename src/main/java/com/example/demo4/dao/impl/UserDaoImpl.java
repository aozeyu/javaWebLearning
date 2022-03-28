package com.example.demo4.dao.impl;

import com.example.demo4.bean.User;
import com.example.demo4.dao.UserDao;
import com.example.demo4.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class UserDaoImpl implements UserDao {

    @Override
    public void addUser(User user) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement("INSERT INTO t_user(name,password,email,birthday) VALUES (?,?,?,?)");
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String birthday = sdf.format(user.getBirthday());
            ps.setString(4,birthday);
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException("添加失败! ");
        }
    }

    @Override
    public User findUserByNameAndPassword(User user) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement("select * from t_user where name=? and password=?");
            ps.setString(1,user.getName());
            ps.setString(2,user.getPassword());
            rs = ps.executeQuery();
            if (rs.next()) {
                u = new User();
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setBirthday(rs.getDate(5));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return  u;
    }
}
