package com.codegym.student_mng.repositories;

import com.codegym.student_mng.database.DBConnection;
import com.codegym.student_mng.models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

public class StudentRepo implements IStudentRepo {
    @Override
    public List<Student> selectAll() throws SQLException {
        List<Student> students = new ArrayList<>();
        Connection connection = new DBConnection().getConnection();
        String sql = " select * from student";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            Student student = new Student(id, name, email, phone);
            students.add(student);
        }
        return students;
    }

    @Override
    public void insertStudent(Student student) throws SQLException {
        Connection connection = new DBConnection().getConnection();
        String sql = "insert into student(name,email,phone) value(?,?,?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, student.getName());
        ps.setString(2, student.getEmail());
        ps.setString(3, student.getPhone());
        ps.executeUpdate();
    }

    @Override
    public void deleteStudent(int id) throws SQLException {
        Connection connection = new DBConnection().getConnection();
        String sql = " delete from student where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Student selectStudent(int id) {
        Student student = null;
        Connection connection = new DBConnection().getConnection();
        String sql = "select * from student where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id1 = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                student = new Student(id1,name, email, phone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return student;
    }

    @Override
    public void updateStudent(Student student) throws SQLException {
        Connection connection = new DBConnection().getConnection();
        String sql = "update student set name = ? ,email=?,phone=? where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, student.getName());
        ps.setString(2, student.getEmail());
        ps.setString(3, student.getPhone());
        ps.setInt(4, student.getId());
        ps.executeUpdate();
    }
}


