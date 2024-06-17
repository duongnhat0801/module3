package com.codegym.user_manager.repositories;


import com.codegym.user_manager.database.DBConnect;
import com.codegym.user_manager.models.User;

import javax.xml.namespace.QName;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

public class UserRepo implements IUserRepo {

    @Override
    public List<User> selectAll() throws SQLException {
        List<User> users = new ArrayList<>();
        Connection connection = new DBConnect().getConnection();
        String sql = " select * from users";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String country = rs.getString("country");
            User user = new User(id, name, email, country);
            users.add(user);
        }
        return users;
    }

    @Override
    public void insertUser(User user) throws SQLException {
        Connection connection = new DBConnect().getConnection();
        String sql = "insert into users(name,email,country) value(?,?,?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, user.getName());
        ps.setString(2, user.getEmail());
        ps.setString(3, user.getCountry());
        ps.executeUpdate();
    }

    @Override
    public void deleteUser(int id) throws SQLException {
        Connection connection = new DBConnect().getConnection();
        String sql = "delete from users where id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public void updateUser(User user) throws SQLException {
        Connection connection = new DBConnect().getConnection();
        String sql = "update users set name = ? ,email=?,country=? where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, user.getName());
        ps.setString(2, user.getEmail());
        ps.setString(3, user.getCountry());
        ps.setInt(4,user.getId());
        ps.executeUpdate();
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        Connection connection = new DBConnect().getConnection();
        String sql = "select * from users where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id,name, email, country);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}






