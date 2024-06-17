package com.codegym.demo2;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/b")
public class B extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String name = request.getParameter("a");
        PrintWriter out = response.getWriter();
        System.out.println(name);
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Web tài xỉu</title>");
        out.println("</head>");
        out.println("<body>");
        if(Objects.equals(name, "nhat")) {
            out.println("<h1> Hello " + name + "</h1>" );

        }else {
            out.println("<h1> Hello " + name + "</h1>" );
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}

