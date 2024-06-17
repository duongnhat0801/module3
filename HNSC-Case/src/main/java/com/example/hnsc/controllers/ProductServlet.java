package com.example.hnsc.controllers;

import com.example.hnsc.models.Category;
import com.example.hnsc.models.Product;
import com.example.hnsc.services.category.CategoryService;
import com.example.hnsc.services.product.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/admin/products/*")
public class ProductServlet extends HttpServlet {
    private static ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/list":
                showList(req, resp);
                break;
            case "/create":
                showFormCreateProduct(req, resp);
                break;
            case "/delete":
                deleteProduct(req, resp);
                break;
            case "/update":
                showFormUpdateProduct(req, resp);
                break;
            case "/search":
                searchProduct(req, resp);
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/create":
                insertProduct(req, resp);
                break;
            case "/update":
                updateProduct(req, resp);
                break;
        }
    }


    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.selectAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/views/product/list.jsp").forward(req, resp);
    }

    private void showFormCreateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryService categoryService = new CategoryService();
        List<Category> categories = categoryService.selectAll();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/views/product/create.jsp").forward(req, resp);
    }

    private void insertProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String sku = req.getParameter("sku");
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");
        String avatar = req.getParameter("avatar");
        int category_id = Integer.parseInt(req.getParameter("category_id"));
        double cost_price = Double.parseDouble(req.getParameter("cost_price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        Product product = new Product(sku, name, price, description, avatar, cost_price, quantity,category_id);
        productService.insert(product);
        resp.sendRedirect("/admin/products/list");
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        productService.delete(id);
        List<Product> products = productService.selectAll();
        req.setAttribute("products", products);
        resp.sendRedirect("/admin/products/list");
    }

    private void showFormUpdateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.selectProduct(id);
        req.setAttribute("product", product);

        CategoryService categoryService = new CategoryService();
        List<Category> categories = categoryService.selectAll();
        req.setAttribute("categories", categories);

        req.getRequestDispatcher("/views/product/update.jsp").forward(req, resp);
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String sku = req.getParameter("sku");
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");
        String avatar = req.getParameter("avatar");
        double cost_price = Double.parseDouble(req.getParameter("cost_price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int category_id = Integer.parseInt(req.getParameter("category_id"));
        Product product = new Product(id, sku, name, price, description, avatar, cost_price, quantity, category_id);
        productService.update(product);

        Category category = new Category();
        resp.sendRedirect("/admin/products/list");
    }

    private void searchProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        List<Product> products = productService.searchProductByName(keyword);
        req.setAttribute("products",products);
        req.getRequestDispatcher("/views/product/list.jsp").forward(req,resp);
    }


}
