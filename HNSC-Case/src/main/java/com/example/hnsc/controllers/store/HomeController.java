package com.example.hnsc.controllers.store;

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

@WebServlet(name = "HomeController", urlPatterns = "/store")
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException, java.io.IOException {
        String url = req.getRequestURI();
        switch (url) {
            case "/store":
                showHome(req, resp);
                break;
            default:
                resp.sendError(404);
                break;
        }
    }

    private void showHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = new CategoryService().selectAll();
        req.setAttribute("categories", categories);
        List<Product> products = new ProductService().searchProductByName("", 8);
        req.setAttribute("products", products);
        req.getRequestDispatcher("/views/store/home.jsp").forward(req, resp);

    }
}
