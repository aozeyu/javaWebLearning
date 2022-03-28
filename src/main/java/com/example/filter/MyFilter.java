package com.example.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class MyFilter implements Filter {
    public MyFilter() {
        System.out.println("实力化");
    }
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");
    }


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("过滤请求");
        //通过过滤器继续访问资源
        chain.doFilter(request, response);
        System.out.println("过滤响应");
    }

    public void destroy() {
        System.out.println("销毁");
    }

    /**
     * Check if a given log record should be published.
     *
     * @param record a LogRecord
     * @return true if the log record should be published.
     */
    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}
