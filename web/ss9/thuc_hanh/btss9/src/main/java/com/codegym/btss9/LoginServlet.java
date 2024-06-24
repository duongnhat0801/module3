package com.codegym.btss9;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.Date;
@WebServlet(name="LoginServlet",urlPatterns = "/login/*" )
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Lấy username và password từ request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Kiểm tra username và password
        if (username.equals("admin") && password.equals("123abc")) {
            // Đăng nhập thành công
            Date currentTime = new Date();
            String message = "admin đăng nhập thành công vào lúc " + currentTime.toString();

            // Set message vào request attribute
            request.setAttribute("message", message);

            // Chuyển hướng đến success.jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher("/success.jsp");
            dispatcher.forward(request, response);
        } else {
            // Đăng nhập không thành công
            request.setAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }
    }
}

