package com.zhu.web.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
 replace HttpServlet, method Dispatcher
 */
public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. get request uri
        String requestURI = req.getRequestURI(); // /brand-case/brand/selectAll

        //2. get method name
        int index = requestURI.lastIndexOf('/');
        String methodName = requestURI.substring(index+1); // [)

        // 3 execute method
        // get ***Servlet class
        // this : who use I ( BrandServlet or UserServlet)
        Class<? extends BaseServlet> cls = this.getClass();

        // get method class
        try {
            Method method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

}
