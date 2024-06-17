package com.example.hnsc.repositories.user;

import com.example.hnsc.models.Category;
import com.example.hnsc.models.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepo {
    User findUserByEmailAndPassword(String email, String password);
}
