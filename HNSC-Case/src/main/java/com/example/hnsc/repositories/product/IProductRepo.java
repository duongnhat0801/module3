package com.example.hnsc.repositories.product;

import com.example.hnsc.models.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductRepo {
    List<Product> selectAll() throws SQLException;

    void insert(Product product) throws SQLException;

    Product selectProduct(int id) throws SQLException;

    void delete(int id) throws SQLException;

    void update(Product product) throws SQLException;
    List<Product> searchProductByName(String keyword) throws SQLException;
    List<Product> searchProductByName(String keyword, int limit);

    List<Product> getProductByCategoryId(int categoryId);
}

