package com.codegym.student_mng.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private String jdbcURL = "jdbc:mysql://localhost:3306/student_manager?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "080102nhat";
 public Connection getConnection(){
Connection connection = null;
     try {
         Class.forName("com.mysql.jdbc.Driver");
         connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
         System.out.println("thanhf cong");
     } catch (SQLException e) {
         System.out.println("khong thanh cong");
         e.printStackTrace();
     } catch (ClassNotFoundException e) {
         System.out.println("khong thanh cong");
         e.printStackTrace();
     }
     return connection;
 }
}
