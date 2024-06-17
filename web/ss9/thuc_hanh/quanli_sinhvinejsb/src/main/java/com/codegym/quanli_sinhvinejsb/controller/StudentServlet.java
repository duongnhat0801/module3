package com.codegym.quanli_sinhvinejsb.controller;

import com.codegym.quanli_sinhvinejsb.sevices.StudentSevice;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "StudentServlet", urlPatterns = "/students/*")
public class StudentServlet extends HttpServlet {
    private StudentSevice studentSevice;

    @Override
    public void init(ServletConfig config) throws ServletException {
        studentSevice = new StudentSevice();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        switch (url) {
            case "/students/list":
                try {
                    this.studentSevice.renderPageListStudent(req, resp);
                } catch (SQLException e) {
                    throw new ServletException(e);
                }
                break;
            case "/students/create":
                try {
                        this.studentSevice.renderPageCreateStudent(req,resp);
                } catch (SQLException e) {
                    throw new ServletException(e);
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        switch (url) {
                case "/students/list":
                    try {
                        this.studentSevice.crreateStudent(req,resp);
                    } catch (SQLException e) {
                        throw new ServletException(e);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
        }
    }

}
