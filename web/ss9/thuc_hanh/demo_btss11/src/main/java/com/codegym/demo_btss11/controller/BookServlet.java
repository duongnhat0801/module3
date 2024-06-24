package com.codegym.demo_btss11.controller;

import com.codegym.demo_btss11.model.Book;
import com.codegym.demo_btss11.service.BookService;
import com.codegym.demo_btss11.service.IBookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet", urlPatterns = "/book/*")
public class BookServlet extends HttpServlet {
    IBookService BookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        req.setCharacterEncoding("UTF-8");
        switch (url) {
            case "/list":
                showListBook(req, resp);
                break;
            case "/create":
                showFromCreateBook(req, resp);
                break;
            case "/delete":
                deleteBook(req, resp);
                break;
            case "/update":
                showFromUpdateBook(req, resp);
                break;
        }
    }

    private void showFromUpdateBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Book book = BookService.selectBook(id);
        req.setAttribute("book", book);
        req.getRequestDispatcher("/views/update.jsp").forward(req, resp);
    }

    private void deleteBook(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        BookService.deleteBook(id);
        resp.sendRedirect("/book/list");
    }

    private void showFromCreateBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/create.jsp").forward(req, resp);
    }

    private void showListBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = BookService.selectAll();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/views/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        req.setCharacterEncoding("UTF-8");
        switch (url) {
            case "/create":
                createBook(req, resp);
                break;
            case "/update":
                updateBook(req,resp);
                break;
        }
    }

    private void updateBook(HttpServletRequest req, HttpServletResponse resp) throws IOException {
     int id = Integer.parseInt(req.getParameter("id"));
     String title = req.getParameter("title");
     int pageSize = Integer.parseInt(req.getParameter("pageSize"));
     String author = req.getParameter("author");
     String category = req.getParameter("category");
     Book book = new Book(id,title,pageSize,author,category);
     BookService.updateBook(book);
     resp.sendRedirect("/book/list");
    }

    private void createBook(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String title = req.getParameter("title");
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));
        String author = req.getParameter("author");
        String category = req.getParameter("category");
        Book book = new Book(title, pageSize, author, category);
        BookService.createBook(book);
        resp.sendRedirect("/book/list");
    }
}

