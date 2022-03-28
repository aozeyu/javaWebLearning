package com.example.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.List;
import java.util.Map;

public class MySessionListener implements HttpSessionListener {
    public void sessionDestroy(HttpSessionEvent se) {
        HttpSession currentSession = se.getSession();
        ServletContext sc = currentSession.getServletContext();
        Map<String, List<HttpSession>> ipMap = (Map<String, List<HttpSession>>) sc.getAttribute("ipMap");
        String ip = (String) currentSession.getAttribute("ip");
        List<HttpSession> sessionsList = ipMap.get(ip);

        sessionsList.remove(currentSession);
        if (sessionsList.size() ==0) {
            ipMap.remove(ip);
        }else {
            ipMap.put(ip,sessionsList);
        }
        sc.setAttribute("ipMap", ipMap);
    }
}
