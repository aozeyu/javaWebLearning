package com.example.demo4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
@WebServlet(name = "ShowCart",value = "/ShowCart")
public class ShowCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("购物车有以下商品：<br/>");
        HttpSession session = request.getSession();
        //得到session对象
        Map<String,Integer> books = (Map<String,Integer>)session.getAttribute("ShoppingCart");
        if(books==null){
            out.print("购物车为空");
            response.setHeader("refresh", "2;url=/ShowBook");
            return;
        }
        for (Map.Entry<String, Integer> book : books.entrySet()) {
            Book b = new Book();
            b = DBUtil.findBookById(book.getKey());
            out.write("名称：" + b.getName() + ",数量：" + book.getValue() + "<br/>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
