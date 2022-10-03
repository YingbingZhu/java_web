package com.zhu.web.request;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/req4")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 2. fix Chinese: POST.getReader()
//        request.setCharacterEncoding("UTF-8");

        // get username
        String username = request.getParameter("username");
        System.out.println(username);

        // GET getQueryString()
        // decode method is Tomcat is not UTF-8, ISO-8859-1
        // convert to byte
        byte[] bytes = username.getBytes(StandardCharsets.ISO_8859_1);

        username = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(username);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
