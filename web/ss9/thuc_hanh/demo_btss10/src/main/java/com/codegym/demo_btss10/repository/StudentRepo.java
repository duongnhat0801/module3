package com.codegym.demo_btss10.repository;

import com.codegym.demo_btss10.database.DBConnection;
import com.codegym.demo_btss10.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements IStudentRepo {
    @Override
    public List<Student> selecAll() throws SQLException {
        List<Student> students = new ArrayList<>();
        Connection connection = new DBConnection().getConnection();
        String sql = "select * from student";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String gender = rs.getString("gender");
            int score = rs.getInt("score");
            Student student = new Student(id,name,gender,score);
            students.add(student);
        }
        return students;
    }
}
