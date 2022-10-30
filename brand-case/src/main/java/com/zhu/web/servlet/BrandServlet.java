package com.zhu.web.servlet;


import com.alibaba.fastjson.JSON;
import com.zhu.pojo.Brand;
import com.zhu.pojo.PageBean;
import com.zhu.service.BrandService;
import com.zhu.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{
    private BrandService brandService = new BrandServiceImpl();

    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Brand> brands = brandService.selectAll();

        String s = JSON.toJSONString(brands);

        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(s);

    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        BufferedReader reader = req.getReader();
        String s1 = reader.readLine();


        Brand brand = JSON.parseObject(s1, Brand.class);
        brandService.add(brand);

        resp.getWriter().write("success");
    }

    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        BufferedReader reader = req.getReader();
        String s1 = reader.readLine();

        Brand brand = JSON.parseObject(s1, Brand.class);
        brandService.update(brand);

        resp.getWriter().write("success");
    }

    public void deleteById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {

        String id = req.getParameter("id");

        brandService.deleteById(Integer.parseInt(id));

        resp.getWriter().write("success");
    }

    public void deleteByIds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {

        // [1,2,3]
        BufferedReader reader = req.getReader();
        String s1 = reader.readLine(); // json

        // convert to int[]
        int[] ids = JSON.parseObject(s1, int[].class);

        brandService.deleteByIds(ids);

        resp.getWriter().write("success");
    }

    public void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get current page and page size: url?currentPage=1&pageSize=5

        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");

        int pageSize = Integer.parseInt(_pageSize);
        int currentPage = Integer.parseInt(_currentPage);

        // service
        PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);

        String s = JSON.toJSONString(pageBean);

        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(s);

    }

    public void selectByPageAndCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get current page and page size: url?currentPage=1&pageSize=5

        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");

        int pageSize = Integer.parseInt(_pageSize);
        int currentPage = Integer.parseInt(_currentPage);

        // get condition object
        BufferedReader reader = req.getReader();
        String s1 = reader.readLine(); // json
        Brand brand = JSON.parseObject(s1, Brand.class);

        // service
        PageBean<Brand> pageBean = brandService.selectByPageAndCondition(currentPage, pageSize, brand);

        String s = JSON.toJSONString(pageBean);

        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(s);

    }



}
