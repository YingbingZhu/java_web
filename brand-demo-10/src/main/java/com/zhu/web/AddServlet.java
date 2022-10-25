package com.zhu.web;

import com.alibaba.fastjson2.*;
import com.zhu.pojo.Brand;
import com.zhu.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {

    private BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String brandName = request.getParameter("brandName");
//        String companyName = request.getParameter("companyName");
//        String ordered = request.getParameter("ordered");
//        String description = request.getParameter("description");
//        String status = request.getParameter("status");
//
//        Brand brand = new Brand();
//        brand.setBrandName(brandName);
//        brand.setStatus(Integer.parseInt(status));
//        brand.setCompanyName(companyName);
//        brand.setDescription(description);
//        brand.setOrdered(Integer.parseInt(ordered));
//
//        service.add(brand);
//
//        // forward
//        request.getRequestDispatcher("/selectAllServlet").forward(request, response);

        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        System.out.println(s);

//        String s1 = (String) JSON.parse(s);
//        System.out.println(s1);
        Brand brand = JSON.parseObject(s, Brand.class);
        System.out.println(brand);

        brandService.add(brand);

        response.getWriter().write("success");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
