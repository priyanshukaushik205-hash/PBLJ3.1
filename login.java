package com.example.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "1234".equals(password)) {
            out.println("<h2>Welcome, " + username + "!</h2>");
            out.println("<a href='search.html'>View Employees</a><br>");
            out.println("<a href='attendance.jsp'>Mark Attendance</a>");
        } else {
            out.println("<h2>Invalid credentials. Please try again.</h2>");
        }
    }
}
