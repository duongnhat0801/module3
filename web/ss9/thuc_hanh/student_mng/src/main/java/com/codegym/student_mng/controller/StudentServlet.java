package com.codegym.student_mng.controller;

import com.codegym.student_mng.models.Student;
import com.codegym.student_mng.services.IStudentService;
import com.codegym.student_mng.services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "StudentServlet", urlPatterns = "/students/*")
public class StudentServlet extends HttpServlet {
    IStudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/list":
                showListStudent(req, resp);
                break;
            case "/create":
                showFormCreateStudent(req, resp);
                break;
            case "/delete":
                deleteStudent(req, resp);
                break;
            case "/update":
                showFormUpdateStu(req, resp);
                break;
        }
    }

    private void showFormUpdateStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = studentService.selectStudent(id);
        System.out.println(student.getId());
        req.setAttribute("student", student);
        req.getRequestDispatcher("/views/update.jsp").forward(req,resp);
    }

    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        studentService.deleteStudent(id);
        resp.sendRedirect("/students/list");
    }

    private void showFormCreateStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/create.jsp").forward(req, resp);
    }

    private void showListStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = studentService.selectAll();
        req.setAttribute("student", students);
        req.getRequestDispatcher("/views/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ádasdasd");
        String url = req.getPathInfo();
        switch (url) {
            case "/create":
                createStudent(req, resp);
                break;
            case "/update":
                updateStudent(req, resp);
                break;
        }
    }

    private void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        Student student = new Student(id, name, email, phone);
        studentService.updateStudent(student);
        resp.sendRedirect("/students/list");

    }

    private void createStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        Student student = new Student(name, email, phone);
        studentService.insertStudent(student);
        resp.sendRedirect("/students/list");
    }

}
