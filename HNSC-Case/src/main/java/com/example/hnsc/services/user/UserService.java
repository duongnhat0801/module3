package com.example.hnsc.services.user;

import com.example.hnsc.models.User;
import com.example.hnsc.repositories.user.UserRepo;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class UserService implements IUserService{
    UserRepo userRepo = new UserRepo();
    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        return new UserRepo().findUserByEmailAndPassword(email, password);
    }

    @Override
    public void addUser(User user) {
        userRepo.addUser(user);
    }

    @Override
    public List<User> selectAll() {
        try {
            return userRepo.selectAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User findById(int id) {
        return userRepo.findById(id);
    }

    @Override
    public void deleteUser(int id) {
        userRepo.deleteUser(id);
    }

    @Override
    public void updateUser(User user) {
        userRepo.updateUser(user);
    }

    public List<String> validate (User user){
        List<String> err = new ArrayList<>();
        if(user.getName().isEmpty()){
            err.add("không được để trống tên");
        }
        return err;
    }
}
