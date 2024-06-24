package com.codegym.demo_btss10.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo_btss10?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "080102nhat";
    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("thành công");
        } catch (SQLException e) {
            System.out.println("Không thành công");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Không thành công");
            e.printStackTrace();
        }
        return connection;
    }
}

