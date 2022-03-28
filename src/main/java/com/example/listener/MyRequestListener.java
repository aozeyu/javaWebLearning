package com.example.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyRequestListener implements ServletRequestListener {
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        String ip = request.getRemoteAddr();
        System.out.println(ip);
        ServletContext sc = sre.getServletContext();
        Map<String, List<HttpSession>> ipMap = (Map<String, List<HttpSession>>) sc.getAttribute("ipMap");
        List<HttpSession> list = ipMap.get(ip);
        if (list == null) {
            list = new ArrayList<>();
        }
        HttpSession currentSession = request.getSession();
        for (HttpSession s : list) {
            if (s == currentSession) {
                return;
            }
        }
        list.add(currentSession);
        ipMap.put(ip,list);
        sc.setAttribute("ipMap", ipMap);
        currentSession.setAttribute("ip",ip);
    }
}
