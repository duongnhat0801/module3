package com.codegym.quanli_sinhvinejsb.repository;

import com.codegym.quanli_sinhvinejsb.database.DBConnect;
import com.codegym.quanli_sinhvinejsb.entities.Classroom;
import com.codegym.quanli_sinhvinejsb.entities.Student;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private Connection connection;

    public StudentRepository() {
        DBConnect dbConnection = new DBConnect();
        this.connection = dbConnection.getConnection();
    }

    public List<Student> getAllStudents() throws SQLException {

            String sql = "select s.name,s.email,s.phone,c.name from  student s join c on s.class_id =c.class_id";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            List<Student> students = new ArrayList<Student>();
            while (resultSet.next()) {
                int idStudent = resultSet.getInt("id");
                String nameStudent = resultSet.getString("name");
                String emailStudnet = resultSet.getString("email");
                int phoneStudent = resultSet.getInt("phone");
                int idClass = resultSet.getInt("idClass");
                String nameClass = resultSet.getString("nameClass");
                Classroom classroom = new Classroom(idClass, nameClass);
                Student student = new Student(idStudent, nameStudent, emailStudnet, phoneStudent, classroom);
                students.add(student);
            }
            return students;
    }

    public void save(Student student) throws SQLException {
        String sql = "insert into `student` values(?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, student.getName());
        ps.setString(2, student.getEmail());
        ps.setInt(3, student.getPhone());
        ps.setInt(4,student.getClass_id().getId());
        ps.execute();

    }
}
