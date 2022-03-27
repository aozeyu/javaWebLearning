package com.example.demo4;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieTest01 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie1 = new Cookie("username", "monkey1024");
        Cookie cookie2 = new Cookie("password","123456");

        response.addCookie(cookie1);
        response.addCookie(cookie2);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request,response);
    }
}
