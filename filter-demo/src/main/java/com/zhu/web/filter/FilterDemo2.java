package com.zhu.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

// @WebFilter("/hello.jsp")
@WebFilter("*.jsp")
public class FilterDemo2 implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // before let go, process request
        System.out.println("2.FilterDemo..");

        // let go
        filterChain.doFilter(servletRequest, servletResponse);

        // after let go, process response

        System.out.println("4.FilterDemo..");
    }

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void destroy() {

    }
}
