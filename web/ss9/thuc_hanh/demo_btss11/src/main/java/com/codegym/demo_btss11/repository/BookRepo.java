package com.codegym.demo_btss11.repository;

import com.codegym.demo_btss11.database.DBConnection;
import com.codegym.demo_btss11.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookRepo implements IBookRepo {
    @Override
    public List<Book> selectAll() throws SQLException {
        List<Book> books = new ArrayList<>();
        Connection connection = new DBConnection().getConnection();
        String sql = "select * from book ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            int pageSize = rs.getInt("pageSize");
            String author = rs.getString("author");
            String category = rs.getString("category");
            Book book = new Book(id, title, pageSize, author, category);
            books.add(book);
        }
        return books;
    }

    @Override
    public void createBook(Book book) throws SQLException {
        Connection connection = new DBConnection().getConnection();
        String sql = "insert into book(title,pageSize,author,category) value (?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, book.getTitle());
        ps.setInt(2, book.getPageSize());
        ps.setString(3, book.getAuthor());
        ps.setString(4, book.getCategory());
        ps.executeUpdate();
    }

    @Override
    public void deleteBoook(int id) throws SQLException {
        Connection connection = new DBConnection().getConnection();
        String sql = "delete from book where id =?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Book selectBook(int id) throws SQLException {
        Book book = null;
        Connection connection = new DBConnection().getConnection();
        String sql = "select  * from book where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int bookId = rs.getInt("id");
                String title = rs.getString("title");
                int pageSize = rs.getInt("pageSize");
                String author = rs.getString("author");
                String category = rs.getString("category");
                book = new Book(bookId, title, pageSize, author, category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }

    @Override
    public void updateBook(Book book) throws SQLException {
        Connection connection = new DBConnection().getConnection();
        String sql = "update book set title = ?, pageSize = ?, author = ?, category = ? where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, book.getTitle());
        ps.setInt(2, book.getPageSize());
        ps.setString(3, book.getAuthor());
        ps.setString(4, book.getCategory());
        ps.setInt(5, book.getId());
        ps.executeUpdate();
    }

    @Override
    public List<Book> searchByTitle(String title) throws SQLException {
        List<Book> books = new ArrayList<>();
        Connection connection = new DBConnection().getConnection();
        String sql = "select * from book where title like ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, "%" + title + "%");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String bookTitle = rs.getString("title");
            int pageSize = rs.getInt("pageSize");
            String author = rs.getString("author");
            String category = rs.getString("category");
            Book book = new Book(id, bookTitle, pageSize, author, category);
            books.add(book);
        }
        return books;
    }
}
