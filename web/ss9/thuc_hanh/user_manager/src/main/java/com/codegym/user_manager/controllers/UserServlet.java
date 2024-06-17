package com.codegym.user_manager.controllers;

import com.codegym.user_manager.models.User;
import com.codegym.user_manager.services.IUserService;
import com.codegym.user_manager.services.UserService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

@WebServlet(name="UserServlet",urlPatterns = "/users/*")
public class UserServlet extends HttpServlet {
    private static IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        if(url==null){
            url = "";
        }
        switch (url){
            case "/list":
                showList(req,resp);
                break;
            case "/create":
                showFormCreate(req,resp);
                break;
            case "/delete":
                deleteUser(req,resp);
                break;
            case "/update":
                updateFormUser(req,resp);
                break;
        }
    }

    private void updateFormUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
      int id = Integer.parseInt(req.getParameter("id"));
      User users = userService.selectUser(id);
      req.setAttribute("user",users);
      req.getRequestDispatcher("/views/update.jsp").forward(req,resp);

    }



    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
     int id = Integer.parseInt(req.getParameter("id"));
     userService.deleteUser(id);
     resp.sendRedirect("/users/list");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        if(url == null){
            url = "";
        }
        switch (url){
            case "/create":
                insertUser(req,resp);
                break;
            case    "/update":
                editUser(req,resp);

        }
    }

    private void editUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String  name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        User user = new User(id,name,email,country);
        userService.updateUser(user);
        resp.sendRedirect("/users/list");
    }


    private void insertUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String  name = req.getParameter("name");
      String email = req.getParameter("email");
      String country = req.getParameter("country");
      User user = new User(name,email,country);
      userService.insertUser(user);
      resp.sendRedirect("/users/list");
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/create.jsp").forward(req,resp);
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       List<User> users = userService.selectAll();
       req.setAttribute("users",users);
       req.getRequestDispatcher("/views/list.jsp").forward(req,resp);
    }
}
