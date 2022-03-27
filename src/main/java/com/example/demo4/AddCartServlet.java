package com.example.demo4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
@WebServlet(name = "AddCart",value = "/AddCart")
public class AddCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //取得书籍的id
        String id = request.getParameter("id");
        //得到session对象
        HttpSession session = request.getSession();
        //从session中取出map，其中key存储图书编号，value存储数量
        Map<String,Integer>  map= (Map<String,Integer>)session.getAttribute("ShoppingCart");
        if(map==null){
            map = new HashMap<String,Integer>();
        }
        //如果是null则说明还未向购物车中添加过
        if(map.get(id) == null){
            map.put(id, 1);
        }else{
            //向购物车中书籍的数量加1
            map.put(id, map.get(id) + 1);
        }

        //把map放回到session中
        session.setAttribute("ShoppingCart", map);
        out.print("购物车添加成功！");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
