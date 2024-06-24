package com.codegym.demo_btss10.repository;

import com.codegym.demo_btss10.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentRepo {
    List<Student> selecAll() throws SQLException;

}
