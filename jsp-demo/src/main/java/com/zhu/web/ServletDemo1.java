package com.zhu.web;

import com.zhu.pojo.Brand;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/demo1")
public class ServletDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // prepare data
        List<Brand> brands = new ArrayList<Brand>();
        brands.add(new Brand(1,"squirrels","squirrels",100,"good",1));
        brands.add(new Brand(2,"uniqlp","uniqlp",200,"uniqlp",0));
        brands.add(new Brand(3,"mi","mi",1000,"mi",1));

        // save to request field
        request.setAttribute("brands", brands);
        request.setAttribute("status", 1);

        // forward to el-demo.jsp
//        request.getRequestDispatcher("/el-demo.jsp").forward(request, response);
//        request.getRequestDispatcher("/jstl-if.jsp").forward(request, response);
        request.getRequestDispatcher("/jstl-foreach.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
