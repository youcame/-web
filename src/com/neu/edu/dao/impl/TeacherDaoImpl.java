package com.neu.edu.dao.impl;

import com.neu.edu.dao.TeacherDao;
import com.neu.edu.po.Student;
import com.neu.edu.po.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {
    private Connection connection;

    public TeacherDaoImpl(Connection connection) {
        this.connection = connection;
    }
    @Override
    public void addTeacher(Teacher teacher) throws SQLException {
        String sql = "INSERT INTO teacher (id, password, name, unApprovedCourse) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, teacher.getId());
        statement.setString(2, teacher.getPassword());
        statement.setString(3, teacher.getName());
        statement.setString(4, teacher.getUnApprovedCourse());
        statement.executeUpdate();
    }

    @Override
    public void deleteTeacher(String id) throws SQLException {
        String sql = "DELETE FROM teacher WHERE id = ?";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setString(1,id);
        statement.executeUpdate();
    }

    @Override
    public void updateTeacher(Teacher teacher) throws SQLException {
        String sql = "UPDATE teacher SET password = ?, name = ?, unApprovedCourse = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, teacher.getPassword());
        statement.setString(2, teacher.getName());
        statement.setString(3, teacher.getUnApprovedCourse());
        statement.setString(4, teacher.getId());
        statement.executeUpdate();
    }

    @Override
    public Teacher getTeacherById(String id) throws SQLException {
        Teacher teacher = null;
        String sql = "SELECT * FROM teacher WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String password = resultSet.getString("password");
            String name = resultSet.getString("name");
            String unApprovedCourse = resultSet.getString("unApprovedCourse");
            teacher = new Teacher(id, name, password, unApprovedCourse);
        }
        return teacher;
    }

    @Override
    public List<Teacher> getAllTeachers() throws SQLException {
        List<Teacher> students = new ArrayList<>();
        String sql = "SELECT * FROM teacher";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String password = resultSet.getString("password");
            String name = resultSet.getString("name");
            String unApprovedCourse=resultSet.getString("unApprovedCourse");
            Teacher teacher = new Teacher(id, name, password, unApprovedCourse);
            students.add(teacher);
        }
        return students;
    }

    @Override
    public Teacher getTeacherByName(String name) throws SQLException {
        Teacher teacher = null;
        String sql = "select * from teacher where name = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,name);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String password = resultSet.getString("password");
            String id = resultSet.getString("id");
            String unApprovedCourse = resultSet.getString("unApprovedCourse");
            teacher = new Teacher(id, name, password, unApprovedCourse);
        }
        return teacher;
    }
}
