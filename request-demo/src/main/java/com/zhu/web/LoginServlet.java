package com.zhu.web;

import com.zhu.mapper.UserMapper;
import com.zhu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get parameter
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // my batis
        // 1. get mysqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. get sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. get Mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 4. implement method
        User user = mapper.select(username, password);

        // 5. close
        sqlSession.close();

        response.setContentType("text/html;");
        PrintWriter writer = response.getWriter();
        // check user
        if (user != null) {
            writer.write("success");
        } else {
            writer.write("fail");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
