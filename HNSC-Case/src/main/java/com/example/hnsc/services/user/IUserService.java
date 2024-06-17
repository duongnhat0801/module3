package com.example.hnsc.services.user;
import com.example.hnsc.models.User;

import java.sql.SQLException;
import java.util.List;


public interface IUserService {
    User getUserByEmailAndPassword(String email, String password);
    void addUser(User user);

    List<User> selectAll() throws SQLException;

    User findById(int id);

    void deleteUser(int id);

    void updateUser(User user);
}
