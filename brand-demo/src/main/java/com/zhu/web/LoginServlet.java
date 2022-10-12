package com.zhu.web;

import com.zhu.pojo.User;
import com.zhu.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.HttpCookie;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        String remember = request.getParameter("remember");

        User user = service.login(username, password);

        if (user != null) {

            if ("1".equals(remember)) {
                // set cookie
                Cookie c_username = new Cookie("username", username);
                Cookie c_password = new Cookie("password", password);

                // set cookie lifetime
                c_username.setMaxAge(60 * 60 * 24 * 7);
                c_password.setMaxAge(60 * 60 * 24 * 7);
                // send
                response.addCookie(c_password);
                response.addCookie(c_username);

            }

            // save to session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            //redirect
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/selectAllServlet");

        } else {

            // save error msg
            request.setAttribute("login_msg", "username or password wrong");

            request.getRequestDispatcher("/login.jsp").forward(request, response);


        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
