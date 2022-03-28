package com.example.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyServletContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        Map<String, List<HttpSession>> ipMap = new HashMap<>();
        ServletContext sc = sce.getServletContext();

        sc.setAttribute("ipMap",ipMap);
    }
}
