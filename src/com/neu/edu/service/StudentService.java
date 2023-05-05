package com.neu.edu.service;

import com.neu.edu.po.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {
    public void addStudent(Student student) throws SQLException;
    public void deleteStudent(String id) throws SQLException;
    public void updateStudent(Student student) throws SQLException;
    public Student getStudentById(String id) throws SQLException;
    public List<Student> getAllStudents() throws SQLException;
    public Student getStudentByName(String name) throws SQLException;
}
