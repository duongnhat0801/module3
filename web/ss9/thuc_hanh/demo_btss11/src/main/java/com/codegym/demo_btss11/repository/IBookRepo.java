package com.codegym.demo_btss11.repository;

import com.codegym.demo_btss11.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface IBookRepo {
    List<Book> selectAll() throws SQLException;
    void createBook(Book book) throws  SQLException;
    void deleteBoook(int id) throws SQLException;
    Book selectBook(int id) throws SQLException;
    void updateBook(Book book)throws SQLException;

    List<Book> searchByTitle(String title) throws SQLException;
}
