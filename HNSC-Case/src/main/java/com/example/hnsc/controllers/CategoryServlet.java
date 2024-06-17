package com.example.hnsc.controllers;


import com.example.hnsc.models.Category;
import com.example.hnsc.services.category.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet", urlPatterns = "/admin/categories/*")
public class CategoryServlet extends HttpServlet {
    private CategoryService categoryService = new CategoryService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String url = req.getPathInfo();
        switch (url) {
            case "/create":
                insertCategory(req, resp);
                break;
            case "/update":
                updateCategory(req,resp);
                break;


        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String url = req.getPathInfo();
        switch (url) {
            case "/list":
                showListCategory(req, resp);
                break;
            case "/create":
                showFormCreateCategory(req, resp);
                break;
            case "/delete":
                deleteCategory(req, resp);
                break;
            case "/update":
                showFormUpdate(req,resp);
                break;

        }
    }
    private void insertCategory(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter("name");
        String avatar = req.getParameter("avatar");
        String description = req.getParameter("description");
        Category category = new Category();
        category.setName(name);
        category.setAvatar(avatar);
        category.setDescription(description);
        List<String> err = categoryService.validate(category);
        if (err.isEmpty()) {
            categoryService.insert(category);
            resp.sendRedirect("/admin/categories/list");
        } else {
            req.setAttribute("err", err);
            req.getRequestDispatcher("/views/category/create.jsp").forward(req, resp);
        }
    }
    private void updateCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name =  req.getParameter("name");
        String avatar = req.getParameter("avatar");
        String description = req.getParameter("description");
        Category category = new Category();
        category.setName(name);
        category.setAvatar(avatar);
        category.setDescription(description);
        category.setId(id);
        List<String> err = categoryService.validate(category);
        if (err.isEmpty()) {
            categoryService.updateCategory(category);
            resp.sendRedirect("/admin/categories/list");
        } else {
            req.setAttribute("err", err);
            req.getRequestDispatcher("/views/category/update.jsp").forward(req, resp);
        }

    }
    private void showFormUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        Category category = categoryService.findById(id);
        if(category!=null) {
            req.setAttribute("category", category);
            req.getRequestDispatcher("/views/category/update.jsp").forward(req, resp);
        }
        else {
            resp.sendRedirect("/admin/categories/list");
        }
    }

    private void deleteCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Category category = categoryService.findById(id);
        if (category != null) {
            categoryService.deleteCategory(id);
        }
        resp.sendRedirect("/admin/categories/list");
    }


    private void showFormCreateCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/category/create.jsp").forward(req, resp);
    }

    private void showListCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryService.selectAll();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/views/category/list.jsp").forward(req, resp);
    }


}
