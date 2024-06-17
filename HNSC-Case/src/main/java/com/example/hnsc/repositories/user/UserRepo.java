package com.example.hnsc.repositories.user;

import com.example.hnsc.database.DBConnect;
import com.example.hnsc.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepo {
    public User findUserByEmailAndPassword(String email, String password) {
        Connection connect = new DBConnect().getConnection();
        String sql = "select * from user where email = ? and password = ? limit 1;";
        try {
            PreparedStatement abc = connect.prepareStatement(sql);
            abc.setString(1, email);
            abc.setString(2, password);
            ResultSet rs = abc.executeQuery();
            User user = new User();
            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
            }
            return user;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addUser(User user) {
        try {
            Connection connection = new DBConnect().getConnection();
            String sql = "Insert into user(name,email,password,otp_code) value (?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setInt(4, user.getOtp_code());
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public List<User> selectAll() throws SQLException {
        List<User> userList = new ArrayList<>();
        Connection connection = new DBConnect().getConnection();
        String sql = "select * from user;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail((rs.getString("email")));
            user.setPassword(rs.getString("password"));
            user.setOtp_code(rs.getInt("otp_code"));
            userList.add(user);
        }
        return userList;
    }

    public User findById(int id) {
        try {
            Connection connection = new DBConnect().getConnection();
            String sql = "select * from user where id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail((rs.getString("email")));
                user.setPassword(rs.getString("password"));
                user.setOtp_code(rs.getInt("otp_code"));
                return user;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void deleteUser(int id) {
        try {
            Connection connection = new DBConnect().getConnection();
            String sql = "delete from user where id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateUser(User user) {
        Connection connection = new DBConnect().getConnection();
        String sql = "update user set name = ?, email = ?, password = ?,otp_code = ? where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setInt(4, user.getOtp_code());
            preparedStatement.setInt(5, user.getId());
            preparedStatement.executeUpdate();
            System.out.println(user.getEmail());
            System.out.println(user.getId());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

