package com.example.hnsc.controllers.store;

import com.example.hnsc.models.Product;
import com.example.hnsc.services.product.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", urlPatterns = "/store/products/*")
public class ProductController extends HttpServlet {
    ProductService productService = new ProductService();
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException, java.io.IOException {
        String url = req.getRequestURI();
        switch (url) {
            case "/store/products/show":
                showProduct(req, resp);
                break;
            case "/store/products/list":
                showAllProduct(req,resp);
                break;
            default:
                resp.sendError(404);
                break;
        }
    }

    private void showAllProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.selectAll();
        req.setAttribute("products",products);
        req.getRequestDispatcher("/views/store/products/list.jsp").forward(req,resp);
    }

    private void showProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id =Integer.parseInt(req.getParameter("id")) ;
        System.out.println(id);
        Product product = productService.selectProduct(id);
        req.setAttribute("product",product);
        req.getRequestDispatcher("/views/store/products/show.jsp").forward(req, resp);
    }
}
