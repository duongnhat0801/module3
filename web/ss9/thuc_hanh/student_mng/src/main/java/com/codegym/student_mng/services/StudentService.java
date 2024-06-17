package com.codegym.student_mng.services;

import com.codegym.student_mng.models.Student;
import com.codegym.student_mng.repositories.IStudentRepo;
import com.codegym.student_mng.repositories.StudentRepo;

import java.sql.SQLException;

import java.util.List;

public class StudentService implements IStudentService{
     IStudentRepo studentRepo = new StudentRepo();
    @Override
    public List<Student> selectAll() {
        try {
            return studentRepo.selectAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void insertStudent(Student student) {
        try {
            studentRepo.insertStudent(student);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteStudent(int id) {
        try {
            studentRepo.deleteStudent(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student selectStudent(int id) {
        try {
           return studentRepo.selectStudent(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateStudent(Student student) {
        try {
            studentRepo.updateStudent(student);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
