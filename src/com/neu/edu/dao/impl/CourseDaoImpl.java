package com.neu.edu.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.neu.edu.po.Course;
import com.neu.edu.dao.CourseDao;

public class CourseDaoImpl implements CourseDao {
    private Connection connection;

    public CourseDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addCourse(Course course) throws SQLException {
        String sql = "INSERT INTO course (id, name, date, teacherName, approval) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, course.getId());
        statement.setString(2, course.getName());
        statement.setString(3, course.getDate());
        statement.setString(4, course.getTeacherName());
        statement.setString(5, course.getApproval());
        statement.executeUpdate();
    }

    @Override
    public void deleteCourse(String id) throws SQLException {
        String sql = "DELETE FROM course WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, id);
        statement.executeUpdate();
    }

    @Override
    public void updateCourse(Course course) throws SQLException {
        String sql = "UPDATE course SET name = ?, date = ?, teacherName = ?, approval = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, course.getName());
        statement.setString(2, course.getDate());
        statement.setString(3, course.getTeacherName());
        statement.setString(4, course.getApproval());
        statement.setString(5, course.getId());
        statement.executeUpdate();
    }

    @Override
    public Course getCourseById(String id) throws SQLException {
        Course course = null;
        String sql = "SELECT * FROM course WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String date = resultSet.getString("date");
            String teacherName = resultSet.getString("teacherName");
            String approval = resultSet.getString("approval");
            course = new Course(id, name, date, teacherName, approval);
        }
        return course;
    }

    @Override
    public List<Course> getAllCourses() throws SQLException {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM course";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String date = resultSet.getString("date");
            String teacherName = resultSet.getString("teacherName");
            String approval = resultSet.getString("approval");
            Course course = new Course(id, name, date, teacherName, approval);
            courses.add(course);
        }
        return courses;
    }

    @Override
    public Course getCourseByName(String name) throws SQLException {
        Course course = null;
        String sql = "SELECT * FROM course WHERE name = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String date = resultSet.getString("date");
            String teacherName = resultSet.getString("teacherName");
            String approval = resultSet.getString("approval");
            course = new Course(id, name, date, teacherName, approval);
        }
        return course;
    }
}
