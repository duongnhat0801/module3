package com.codegym.user_manager.services;

import com.codegym.user_manager.models.User;

import java.util.List;

public interface IUserService {
    List<User> selectAll();
    void insertUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
    User selectUser(int id);
}
