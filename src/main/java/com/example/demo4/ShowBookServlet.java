package com.example.demo4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
@WebServlet(name ="ShowBookServlet" ,value = "/ShowBookServlet")
public class ShowBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("全部java书籍：<br/>");

        //取得全部书籍
        Map<String, Book> books = DBUtil.findAllBooks();

        //生成html
        for (Map.Entry<String, Book> book : books.entrySet()) {
            String url1 = "/demo4_war_exploded/AddCart?id="+book.getKey();
            out.print("<a href='"+url1+"' >"+book.getValue().getName()+"</a><br/>");
        }
        String url2 = "/demo4_war_exploded/ShowCart";
        out.print("<a href='"+url2+"'>查看购物车</a> <br/>");

        String url3 = "/demo4_war_exploded/ClearCart";
        out.print("<a href='"+url3+"'>清空购物车</a> <br/>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
