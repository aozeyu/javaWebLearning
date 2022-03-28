package com.example.demo4.servlet;

import com.example.demo4.bean.User;
import com.example.demo4.service.UserService;
import com.example.demo4.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@WebServlet(name = "RegistServlet",value = "/RegistServlet")
public class RegistServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected  void  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        User u = new User();
        u.setName(request.getParameter("name"));
        u.setPassword(request.getParameter("password"));
        u.setEmail(request.getParameter("email"));
        String birthday = request.getParameter("birthday");
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(birthday);
            u.setBirthday(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //调用业务逻辑
        UserService us = new UserServiceImpl();
        try {
            us.addUser(u);
            response.getWriter().write("注册成功! 1秒跳转主页");
            response.setHeader("refresh","1;url=/login.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
