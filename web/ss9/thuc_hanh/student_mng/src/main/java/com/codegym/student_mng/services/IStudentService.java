package com.codegym.student_mng.services;

import com.codegym.student_mng.models.Student;

import java.util.List;

public interface IStudentService {
    List<Student> selectAll();
    void insertStudent(Student student);
    void deleteStudent(int id);
    Student selectStudent(int id);
    void updateStudent(Student student);
}
