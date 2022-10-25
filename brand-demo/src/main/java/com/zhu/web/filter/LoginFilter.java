package com.zhu.web.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * login filter
 */
// @WebFilter("/*")
public class LoginFilter implements Filter {


    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        // check if session has User
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        // check if related to login
        String[] urls = {"/login.jsp", "/imgs/", "/css/", "/loginServlet", "register.jsp", "/registerServlet", "/checkCodeServlet"};

        String url = req.getRequestURL().toString();

        for (String u:urls) {
            if(url.contains(u)){
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }

        HttpSession session = req.getSession();

        Object user = session.getAttribute("user");

        if (user != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            req.setAttribute("login_msg", "not login");
            req.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
        }

    }

    public void init(FilterConfig filterConfig) throws ServletException {
    }


    public void destroy() {
    }
}
