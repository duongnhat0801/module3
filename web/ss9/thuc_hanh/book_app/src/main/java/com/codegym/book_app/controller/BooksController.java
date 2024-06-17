package com.codegym.book_app.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

@WebServlet(name = "BooksController", urlPatterns = "/books/*")
public class BooksController extends HttpServlet {
    List<Book> books = new ArrayList<Book>();
    private HttpSession request;
    private HttpSession response;
}
