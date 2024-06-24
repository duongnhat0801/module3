package com.codegym.demo_btss9;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "LoginServlet", urlPatterns = "/login/*")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        if(url == null){
            req.getRequestDispatcher("/views/login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            if (username.equals("admin") && password.equals("123abc")) {
                Date currentTime = new Date();
                String message = "admin đăng nhập thành công vào lúc " + currentTime.toString();
                req.setAttribute("message", message);
                req.getRequestDispatcher("views/success.jsp").forward(req, resp);
            } else {
                req.setAttribute("error", "tên đăng nhập hoặc mật khẩu không đúng");
                req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
            }
        }
    }

