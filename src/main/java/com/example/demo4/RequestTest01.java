package com.example.demo4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

@WebServlet(name = "RequestTest01", value = "/RequestTest01")
public class RequestTest01 extends HttpServlet {
   private static final long serialVersionUID = 1L;
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       request.setCharacterEncoding("UTF-8");
       String username = request.getParameter("username");
       String password = request.getParameter("password");
       request.setAttribute("username",username);
       request.setAttribute("password",password);
       response.sendRedirect("Other");
   }
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       doGet(request,response);
   }
}
