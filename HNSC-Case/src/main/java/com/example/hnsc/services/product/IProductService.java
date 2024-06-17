package com.example.hnsc.services.product;

import com.example.hnsc.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> selectAll();
    void insert(Product product);
    Product selectProduct(int id);
    void delete(int id);
    void update(Product product);
    List<Product> searchProductByName(String keyword);
    List<Product> searchProductByName(String keyword, int limit);
    List<Product> getProductByCategoryId(int categoryId);
}
