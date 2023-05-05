package com.neu.edu.service;

import com.neu.edu.po.Course;
import jakarta.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public interface CourseService {
    public void addCourse(Course course) throws SQLException;
    public void deleteCourse(String id) throws SQLException;
    public void updateCourse(Course course) throws SQLException;
    public Course getCourseById(String id) throws SQLException;
    public List<Course> getAllCourses() throws SQLException;
}
