package com.example.hnsc.services.category;

import com.example.hnsc.models.Category;
import com.example.hnsc.repositories.category.CategoryRepo;
import com.example.hnsc.repositories.category.ICategoryRepo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements ICategoryService {
    private ICategoryRepo categoryRepo = new CategoryRepo();

    @Override
    public List<Category> selectAll() {
        try {
            return new CategoryRepo().selectAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> validate(Category category) {
        List<String> err = new ArrayList<>();
        if (category.getName().isEmpty()) {
            err.add("ko dc de trong ten");
        }
        return err;
    }

    public void insert(Category category) {
        categoryRepo.insertA(category);
    }

    public Category findById(int id) {
        return categoryRepo.findById(id);
    }

    public void deleteCategory(int id) {
        categoryRepo.deleteCategory(id);
    }

    @Override
    public void updateCategory(Category category) {
        categoryRepo.updateCategory(category);
    }


}
