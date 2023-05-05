package com.neu.edu.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.neu.edu.po.Course;
import com.neu.edu.dao.StudentDao;
import com.neu.edu.po.Student;

public class StudentDaoImpl implements StudentDao {
    private Connection connection;

    public StudentDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addStudent(Student student) throws SQLException {
        String sql = "INSERT INTO student (id, password, name, chosenCourse) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, student.getId());
        statement.setString(2, student.getPassword());
        statement.setString(3, student.getName());
        statement.setString(4, student.getChosenCourse());
        statement.executeUpdate();
    }

    @Override
    public void deleteStudent(String id) throws SQLException {
        String sql = "DELETE FROM student WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, id);
        statement.executeUpdate();
    }

    @Override
    public void updateStudent(Student student) throws SQLException {
        String sql = "UPDATE student SET password = ?, name = ?, course = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, student.getPassword());
        statement.setString(2, student.getName());
        statement.setString(3, student.getChosenCourse());
        statement.setString(4, student.getId());
        statement.executeUpdate();
    }

    @Override
    public Student getStudentById(String id) throws SQLException {
        Student student = null;
        String sql = "SELECT * FROM student WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String password = resultSet.getString("password");
            String name = resultSet.getString("name");
            String courses = resultSet.getString("chosenCourse");
            student = new Student(id, password, name, courses);
        }
        return student;
    }

    @Override
    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String password = resultSet.getString("password");
            String name = resultSet.getString("name");
            String courses=resultSet.getString("chosenCourse");
            Student student = new Student(id, password, name, courses);
            students.add(student);
        }
        return students;
    }

    @Override
    public Student getStudentByName(String name) throws SQLException {
        Student student = null;
        String sql = "SELECT * FROM student WHERE name = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String password = resultSet.getString("password");
            String id = resultSet.getString("id");
            String courses = resultSet.getString("chosenCourse");
            student = new Student(id, password, name, courses);
        }
        return student;
    }

}
