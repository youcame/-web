package com.neu.edu.dao;

import com.neu.edu.po.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseDao {
    public void addCourse(Course course) throws SQLException;
    public void deleteCourse(String id) throws SQLException;
    public void updateCourse(Course course) throws SQLException;
    public Course getCourseById(String id) throws SQLException;
    public List<Course> getAllCourses() throws SQLException;
    public Course getCourseByName(String name) throws SQLException;
}
