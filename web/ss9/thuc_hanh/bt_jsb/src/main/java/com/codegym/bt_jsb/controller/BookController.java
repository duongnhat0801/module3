package com.codegym.bt_jsb.controller;

import com.codegym.bt_jsb.model.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "BookController", urlPatterns = {"/books/*"})
public class BookController extends HttpServlet {
    private List<Book> books = new ArrayList<>();
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Override
    public void init(ServletConfig config) throws ServletException {
        Book book1 = new Book("Đắc Nhân Tâm", 18.00, "Quyển sách đưa ra các lời khuyên về cách thức cư xử, ứng xử và giao tiếp với mọi người để đạt được thành công trong cuộc sống", " Dale Carnegie");
        Book book2 = new Book("Những Vụ Kỳ Án Của Sherlock Holmes", 20, "Những Vụ Kỳ Án Của Sherlock Holmes đưa bạn đọc đến những vụ án li kì, hóc búa, biến hoá vô cùng qua từng trang truyện. Tập truyện ghi lại những hiểm nguy, mà ở đó ông thể hiện tài ba phá án phi phàm của mình.", "Conan Doylel");
        Book book3 = new Book("Đừng Để Nỗi Sợ Cản Đường Bạn", 15.44, "Sợ hãi, thậm chí là sợ hãi tột cùng, dứt khoát là một điều rất đỗi con người. Nhưng nếu sợ hãi là một phần bản chất của chúng ta thì lòng dũng cảm cũng vậy.", "Helen Odessky");
        Book book4 = new Book("Thay Đổi Một Suy Nghĩ Thay Đổi Cả Cuộc Đời", 30, "Trong cuốn sách này, tác giả đã tổng kết ra những trường hợp điển hình, thông qua đào sâu phân tích và thảo luận để dẫn mọi người cùng tìm kiếm và nhìn thấy mô thức sống hiện nay của họ", "Hoàng Khải Đoàn");
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);
        System.out.println(book4);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        request = req;
        response = resp;
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        switch (url) {
            case "/books":
                showList();
                break;
            case "/books/new":
                newBook();
                break;

        }
    }

    private void showList() throws ServletException, IOException {
        request.setAttribute("books", books);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/book/index.jsp");
        requestDispatcher.forward(request, response);
    }

    private void newBook() throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/book/new.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.equals("/books/create")) {
            createBook();
        }
    }


    private void createBook() throws ServletException, IOException {
        String name = request.getParameter("name");
        double price;
        try{
            price = Double.parseDouble(request.getParameter("price"));
        }catch (NumberFormatException e){
            price = 0.0;
        }
        String description = request.getParameter("description");
        String author = request.getParameter("author");
        Boolean status = true;
        List<String> errors = new ArrayList<>();
        if (name.isEmpty()) {
            errors.add("Tên không được để trống");
            status = false;
        }
        if (price <= 0) {
            errors.add("Vui lòng nhập giá đúng");
            status = false;
        }
        if (description.isEmpty()) {
            errors.add("Mô tả không được để trống");
            status = false;
        }
        if (author.isEmpty()) {
            errors.add("Vui lòng nhập tên tác giả");
        }
        if (status){
            Book book = new Book(name, price, description, author);
            books.add(book);
            response.sendRedirect("/books");
        }else {
            request.setAttribute("errors", errors);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/book/new.jsp");
        }
    }
}
