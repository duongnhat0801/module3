package com.codegym.demo_btss10.service;

import com.codegym.demo_btss10.model.Student;
import com.codegym.demo_btss10.repository.IStudentRepo;
import com.codegym.demo_btss10.repository.StudentRepo;

import java.sql.SQLException;
import java.util.List;

public class StudentService implements IStudentService{
    IStudentRepo studentRepo = new StudentRepo();
    @Override
    public List<Student> selectAll() {
        try {
            return studentRepo.selecAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
