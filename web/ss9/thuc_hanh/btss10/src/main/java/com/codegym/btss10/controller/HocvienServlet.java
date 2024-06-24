package com.codegym.btss10.controller;

import com.codegym.btss10.model.Hocvien;
import com.codegym.btss10.service.HocvienService;
import com.codegym.btss10.service.IHocvienService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HocvienServlet", urlPatterns = "/hocvien/*")
public class HocvienServlet extends HttpServlet {
    IHocvienService HocvienService = new HocvienService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/list":
                showListHocvien(req, resp);
                break;
        }
    }

    private void showListHocvien(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Hocvien> hocviens = HocvienService.selectAll();
        req.setAttribute("hocvien",hocviens);
        req.getRequestDispatcher("/views/list.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
