package com.codegym.student_mng.repositories;

import com.codegym.student_mng.models.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentRepo {
List<Student> selectAll() throws SQLException;
void insertStudent(Student student) throws SQLException;
void deleteStudent(int id) throws SQLException;
Student selectStudent(int id) throws SQLException;
void updateStudent(Student student) throws  SQLException;
}
