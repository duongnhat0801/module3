package com.codegym.quanli_sinhvinejsb.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class DBConnect {
    private static final String URL = "jdbc:mysql://localhost:3306/quanli_sinhvien?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "080102nhat";
    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.codegym.quanli_sinhvinejsb");
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Connected database successfully");
        }catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
