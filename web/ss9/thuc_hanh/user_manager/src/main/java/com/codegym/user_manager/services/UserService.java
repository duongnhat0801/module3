package com.codegym.user_manager.services;

import com.codegym.user_manager.models.User;
import com.codegym.user_manager.repositories.IUserRepo;
import com.codegym.user_manager.repositories.UserRepo;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService{
    private static IUserRepo userRepo = new UserRepo();

    @Override
    public List<User> selectAll() {
        try {
            return userRepo.selectAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertUser(User user) {
        try {
            userRepo.insertUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteUser(int id) {
        try {
            userRepo.deleteUser(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            userRepo.updateUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User selectUser(int id) {
        try {
            return userRepo.selectUser(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
