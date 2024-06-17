package com.codegym.user_manager.repositories;


import com.codegym.user_manager.models.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepo {
    List<User> selectAll() throws SQLException;
    void insertUser(User user) throws SQLException;
    void deleteUser(int id)throws SQLException;
    void updateUser(User user) throws SQLException;
    User selectUser(int id) throws SQLException;
}
