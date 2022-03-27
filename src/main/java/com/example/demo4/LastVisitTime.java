package com.example.demo4;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LastVisitTime extends HttpServlet {
    private static final  long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            out.write("第一次访问");
        }else {
            for (int i = 0; i < cookies.length; i++) {
                if ("lastVisit".equals(cookies[i].getName())) {
                    out.write("你的最后访问时间为: " + cookies[i].getValue());
                }
            }
        }
        LocalDateTime currentTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd/HH:mm:ss");
        Cookie cookie = new Cookie("lastVisit", currentTime.format(formatter));
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request,response);
    }
}
