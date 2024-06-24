package com.codegym.demo_btss10.controller;

import com.codegym.demo_btss10.model.Student;
import com.codegym.demo_btss10.service.IStudentService;
import com.codegym.demo_btss10.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "StudentServlet", urlPatterns = "/student/*")
public class StudentServlet extends HttpServlet {
    IStudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/list":
                ShowListStudent(req, resp);
                break;
        }
    }

    private void ShowListStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = studentService.selectAll();
        if (students.isEmpty()) {
            String message = "Danh sách rỗng";
            req.setAttribute("message", message);
        } else {
            req.setAttribute("students", students);
            req.getRequestDispatcher("/views/list.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
