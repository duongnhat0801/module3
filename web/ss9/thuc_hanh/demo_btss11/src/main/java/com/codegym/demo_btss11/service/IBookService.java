package com.codegym.demo_btss11.service;

import com.codegym.demo_btss11.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> selectAll();
    void createBook(Book book);
    void deleteBook (int id);
    Book selectBook(int id);
    void updateBook(Book book);
}
