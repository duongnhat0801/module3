package com.example.hnsc.services.category;

import com.example.hnsc.models.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> selectAll();

    void insert(Category category);

    void deleteCategory(int id);

    void updateCategory(Category category);
}
