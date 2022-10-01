package com.zhu.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

@WebServlet("/req2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get..");

        Map<String, String[]> map = req.getParameterMap();
        for (String key: map.keySet()) {
            System.out.println(key+":");

            // get value
            String[] values = map.get(key);
            for (String value:values) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        System.out.println("--------");

        // 2. get parameters
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby:hobbies) {
            System.out.println(hobby);
        }
        
        // 3. get single parameter
        String username = req.getParameter("username");
        System.out.println(username);

        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post..");

        this.doGet(req, resp);
//
//        Map<String, String[]> map = req.getParameterMap();
//        for (String key: map.keySet()) {
//            System.out.println(key+":");
//
//            // get value
//            String[] values = map.get(key);
//            for (String value:values) {
//                System.out.print(value + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println("--------");
//
//        // 2. get parameters
//        String[] hobbies = req.getParameterValues("hobby");
//        for (String hobby:hobbies) {
//            System.out.println(hobby);
//        }
//
//        // 3. get single parameter
//        String username = req.getParameter("username");
//        System.out.println(username);
    }
}
