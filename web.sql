CREATE DATABASE webappdb;
USE webappdb;

CREATE TABLE Employee (
    EmpID INT PRIMARY KEY,
    Name VARCHAR(100),
    Salary DECIMAL(10,2)
);

INSERT INTO Employee VALUES (1, 'John Doe', 55000.00);
INSERT INTO Employee VALUES (2, 'Alice Smith', 72000.00);
INSERT INTO Employee VALUES (3, 'Bob Brown', 48000.00);

CREATE TABLE Attendance (
    StudentID INT,
    Date DATE,
    Status VARCHAR(10)
);
