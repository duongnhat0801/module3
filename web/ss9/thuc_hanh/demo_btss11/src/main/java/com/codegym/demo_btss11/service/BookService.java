package com.codegym.demo_btss11.service;

import com.codegym.demo_btss11.model.Book;
import com.codegym.demo_btss11.repository.BookRepo;
import com.codegym.demo_btss11.repository.IBookRepo;

import java.sql.SQLException;

import java.util.List;

public class BookService implements IBookService {
    IBookRepo BookRepo = new BookRepo();

    @Override
    public List<Book> selectAll() {
        try {
            return BookRepo.selectAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createBook(Book book) {
        try {
            BookRepo.createBook(book);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteBook(int id) {
        try {
            BookRepo.deleteBoook(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book selectBook(int id) {
        try {
          return   BookRepo.selectBook(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateBook(Book book) {
        try {
            BookRepo.updateBook(book);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
