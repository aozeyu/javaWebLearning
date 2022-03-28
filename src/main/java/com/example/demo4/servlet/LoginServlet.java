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
import java.io.UnsupportedEncodingException;
@WebServlet(name = "LoginServlet",value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static  final long serialVersionUID = 1L;
    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        UserService us = new UserServiceImpl();
        try {
            User u = us.findUserByNameAndPassword(user);
            if (u != null) {
                request.getSession().setAttribute("user",u);
                request.getRequestDispatcher("/success.html").forward(request,response);
            }else {
                request.setAttribute("msg","用户名或密码不正确!");
                request.getRequestDispatcher("/login.html").forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
