package com.example.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class EmployeeServlet extends HttpServlet {
    private static final String URL = "jdbc:mysql://localhost:3306/webappdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String empId = request.getParameter("empid");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            String query;
            PreparedStatement ps;

            if (empId != null && !empId.isEmpty()) {
                query = "SELECT * FROM Employee WHERE EmpID = ?";
                ps = con.prepareStatement(query);
                ps.setInt(1, Integer.parseInt(empId));
            } else {
                query = "SELECT * FROM Employee";
                ps = con.prepareStatement(query);
            }

            ResultSet rs = ps.executeQuery();
            out.println("<h2>Employee Records</h2>");
            out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Salary</th></tr>");
            while (rs.next()) {
                out.println("<tr><td>" + rs.getInt("EmpID") + "</td><td>" +
                        rs.getString("Name") + "</td><td>" + rs.getDouble("Salary") + "</td></tr>");
            }
            out.println("</table>");

            con.close();
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}
