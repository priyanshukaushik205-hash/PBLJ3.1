package com.example.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AttendanceServlet extends HttpServlet {
    private static final String URL = "jdbc:mysql://localhost:3306/webappdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String studentId = request.getParameter("studentId");
        String date = request.getParameter("date");
        String status = request.getParameter("status");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO Attendance (StudentID, Date, Status) VALUES (?, ?, ?)"
            );
            ps.setInt(1, Integer.parseInt(studentId));
            ps.setString(2, date);
            ps.setString(3, status);

            int result = ps.executeUpdate();

            if (result > 0)
                out.println("<h2>Attendance marked successfully!</h2>");
            else
                out.println("<h2>Failed to mark attendance.</h2>");

            con.close();
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}
