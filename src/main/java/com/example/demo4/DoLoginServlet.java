package com.example.demo4;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DoLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        Cookie cookie1 = new Cookie("userName",userName);
        Cookie cookie2 = new Cookie("password",password);
        cookie1.setPath("/");
        cookie2.setPath("/");
        if ("admin".equals(userName) && "123456".equals(password)) {
            if (remember != null) {
                cookie1.setMaxAge(60*60*240);
                cookie2.setMaxAge(60*60*240);
                response.addCookie(cookie1);
                response.addCookie(cookie2);
            }
            out.write("登陆成功! ");
        }else {
            out.write("登陆失败! ");
            response.setHeader("refresh", "2;url=/servlet/login");
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
