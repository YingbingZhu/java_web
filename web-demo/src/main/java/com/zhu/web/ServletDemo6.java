package com.zhu.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ServletDemo6 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        // differ request method
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // 1. request method
        String method = request.getMethod();
        // 2. check
        if ("GET".equals(method)) {
            // use get
        } else if ("POST".equals(method)) {
            // use post
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
