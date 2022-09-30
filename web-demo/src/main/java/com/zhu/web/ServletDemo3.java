package com.zhu.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


@WebServlet(urlPatterns="/demo3", loadOnStartup = 0)
public class ServletDemo3 implements Servlet {
    private ServletConfig servletConfig;
    /**
     * initialize:
     * 1. time: first visit;
     *     loadOnStartUp:
     * 2. once
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        System.out.println("init...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    /**
     * provide service
     * 1. time: every visit
     * 2. multiply times
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hello");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 1. time: when memory release and service shut down
     * once
     */
    @Override
    public void destroy() {
        System.out.println("destroy..");
    }
}
