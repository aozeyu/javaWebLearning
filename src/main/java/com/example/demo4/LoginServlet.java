package com.example.demo4;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        String userName = " ";
        String passWord = " ";
        Cookie[] cookies = request.getCookies();
        for (int i = 0; cookies!=null && i< cookies.length; i++) {
            if ("userName".equals(cookies[i].getName())) {
                userName = cookies[i].getValue();
            }
            if ("password".equals(cookies[i].getName())) {
                passWord = cookies[i].getValue();
            }
        }
        if ("admin".equals(userName) && "123456".equals(passWord)) {
            out.write("登陆成功! ");
        }else {
            out.write("<form action='/servlet/doLogin' method='post'>");
            out.write("用户名：<input type='text' name='userName' /><br/>");
            out.write("密码：<input type='password' name='password'/><br/>");
            out.write("<input type='checkbox' name='remember' />十天免登陆<br/>");
            out.write("<input type='submit' value='登录'/><br/>");
            out.write("</form>");
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
