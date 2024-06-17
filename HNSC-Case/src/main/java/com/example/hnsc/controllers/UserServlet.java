package com.example.hnsc.controllers;

import com.example.hnsc.models.Category;
import com.example.hnsc.models.User;
import com.example.hnsc.services.user.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/admin/users/*")
public class UserServlet extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/list":
                showListUser(req, resp);
                break;
            case "/create":
                showFormAddUser(req, resp);
                break;
            case "/delete":
                deleteUser(req, resp);
                break;
            case "/update":
                showFormUpdate(req,resp);
                break;
        }
    }

    private void showFormUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int id = Integer.parseInt(req.getParameter("id"));
       User user =  userService.findById(id);
       if(user!=null){
           req.setAttribute("user",user);
           req.getRequestDispatcher("/views/user/update.jsp").forward(req,resp);
       }
        resp.sendRedirect("/admin/users/list");
    }

    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        User user = userService.findById(id);
        if (user != null) {
            userService.deleteUser(id);
            resp.sendRedirect("/admin/users/list");
        } else {
            resp.sendRedirect("/admin/users/list");
        }

    }

    private void showListUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = userService.selectAll();
        req.setAttribute("userList", userList);
        req.getRequestDispatcher("/views/user/list.jsp").forward(req, resp);
    }


    private void showFormAddUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/user/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/create":
                addUser(req, resp);
                break;
            case "/update":
                updateUser(req,resp);
                break;
        }
    }

    private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        int otp_code = Integer.parseInt(req.getParameter("otp_code"));
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setOtp_code(otp_code);
        user.setId(id);
        List<String> err =  userService.validate(user);
        if(err.isEmpty()){
            userService.updateUser(user);
            resp.sendRedirect("/admin/users/list");
        }
        else {
            req.setAttribute("err",err);
            req.getRequestDispatcher("/views/users/update.jsp").forward(req, resp);

        }

    }

    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String otp_code = req.getParameter("otp_code");
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setOtp_code(Integer.parseInt(otp_code));
        List<String> err = userService.validate(user);
        if (err.isEmpty()) {
            userService.addUser(user);
            resp.sendRedirect("/admin/users/list");
        } else {
            req.setAttribute("err", err);
            req.getRequestDispatcher("/views/user/create.jsp").forward(req, resp);
        }

    }

}
