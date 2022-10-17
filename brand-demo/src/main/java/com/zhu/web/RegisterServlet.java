package com.zhu.web;

import com.zhu.pojo.User;
import com.zhu.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // get check code from user
        String checkCode = request.getParameter("checkCode");
        // get check code from session
        HttpSession session = request.getSession();
        Object checkCodeGen = session.getAttribute("checkCodeGen");

        if (!checkCodeGen.equals(checkCode)) {
            request.setAttribute("register_msg", "wrong checkcode");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            // prevent from register
            return;
        }

        User user = new User();
        user.setPassword(password);
        user.setUsername(username);

        boolean flag = service.register(user);

        if(flag){
            request.setAttribute("register_msg", "sign up success, pls login");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            request.setAttribute("register_msg", "already exist");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
