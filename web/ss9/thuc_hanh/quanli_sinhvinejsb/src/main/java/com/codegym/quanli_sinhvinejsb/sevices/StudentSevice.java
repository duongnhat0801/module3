package com.codegym.quanli_sinhvinejsb.sevices;

import com.codegym.quanli_sinhvinejsb.entities.Classroom;
import com.codegym.quanli_sinhvinejsb.entities.Student;
import com.codegym.quanli_sinhvinejsb.repository.ClassRepository;
import com.codegym.quanli_sinhvinejsb.repository.StudentRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class StudentSevice {

    private StudentRepository studentRepository;

    private ClassRepository classRepository;

    public StudentSevice() {
        this.studentRepository = new StudentRepository();
        this.classRepository = new ClassRepository();
    }

    public void renderPageListStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Student> students = this.studentRepository.getAllStudents();
        request.setAttribute("students", students);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/students/list.jsp");
        requestDispatcher.forward(request, response);

    }

    public void createStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int phone = Integer.parseInt(request.getParameter("phone"));
        int class_id = Integer.parseInt(request.getParameter("class_id"));
        Classroom classroom = this.classRepository.findById(class_id);
        Student student = new Student(name, email, phone, classroom);
        this.studentRepository.save(student);
        response.sendRedirect("/students/list");
    }

    public void renderPageCreateStudent(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        List<Classroom> classrooms = this.classRepository.getAllClassroom();
        req.setAttribute("classrooms", classrooms);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/students/create.jsp");
        requestDispatcher.forward(req, resp);
    }

    public void crreateStudent(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        int phone = Integer.parseInt(req.getParameter("phone"));
        int class_id = Integer.parseInt(req.getParameter("class_id"));
        Classroom classroom = this.classRepository.findById((class_id));
        Student student = new Student(name, email, phone, classroom);
        this.studentRepository.save(student);
        resp.sendRedirect("/students/list");
    }
}
