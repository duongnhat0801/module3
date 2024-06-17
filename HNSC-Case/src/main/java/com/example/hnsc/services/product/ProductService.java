package com.example.hnsc.services.product;

import com.example.hnsc.models.Product;
import com.example.hnsc.repositories.product.IProductRepo;
import com.example.hnsc.repositories.product.ProductRepo;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class ProductService implements IProductService{
    IProductRepo productRepo = new ProductRepo();
    @Override
    public List<Product> selectAll() {
        try {
            return productRepo.selectAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(Product product) {
        try {
            productRepo.insert(product);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product selectProduct(int id) {
        try {
            return productRepo.selectProduct(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            productRepo.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Product product) {
        try {
            productRepo.update(product);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> searchProductByName(String keyword) {
        try {
           return productRepo.searchProductByName(keyword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> searchProductByName(String keyword, int limit) {
        return productRepo.searchProductByName(keyword, limit);
    }

    @Override
    public List<Product> getProductByCategoryId(int categoryId) {
        return productRepo.getProductByCategoryId(categoryId);
    }

}
