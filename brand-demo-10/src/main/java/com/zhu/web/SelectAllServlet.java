package com.zhu.web;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import com.zhu.pojo.Brand;
import com.zhu.service.BrandService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {

    BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {

        // 1. brand service
        List<Brand> brands = brandService.selectAll();

//        request.setAttribute("brands", brands);
//
//        request.getRequestDispatcher("/brand.jsp").forward(request,response);

        // serialize
        String s = JSON.toJSONString(brands, JSONWriter.Feature.IgnoreNonFieldGetter);;
        System.out.println(s);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
