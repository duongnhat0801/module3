package com.example.hnsc.repositories.category;

import com.example.hnsc.models.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryRepo {

    List<Category> selectAll() throws SQLException;
     void insertA(Category category);

    void deleteCategory(int id);
    Category findById(int id);


    void updateCategory(Category category);
}

