package com.zhu.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/req1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get
        String method = req.getMethod();
        System.out.println(method);
        // get catalog
        String contextPath = req.getContextPath();
        System.out.println(contextPath);

        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL.toString());

        String requestURI = req.getRequestURI();
        System.out.println(requestURI);

        String queryString = req.getQueryString();
        System.out.println(queryString);


        // browser version
        String header = req.getHeader("user-agent");
        System.out.println(header);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get parameters

        // 1. string input stream
        BufferedReader br = req.getReader();
        // 2. read data
        String line = br.readLine();
        System.out.println(line);
    }
}
