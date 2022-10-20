package com.zhu.web;

import com.zhu.pojo.Brand;
import com.zhu.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import com.alibaba.fastjson2.*;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {

    BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1. brand service
        List<Brand> brands = brandService.selectAll();

//        request.setAttribute("brands", brands);
//
//        request.getRequestDispatcher("/brand.jsp").forward(request,response);

        // serialize
        String s = JSONObject.toJSONString(brands);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
