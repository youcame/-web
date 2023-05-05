package com.neu.edu.service.impl;

import com.neu.edu.dao.CourseDao;
import com.neu.edu.dao.StudentDao;
import com.neu.edu.dao.impl.StudentDaoImpl;
import com.neu.edu.po.Course;
import com.neu.edu.po.Selection;
import com.neu.edu.po.Student;
import com.neu.edu.service.CourseService;
import com.neu.edu.service.SelectionService;
import com.neu.edu.service.StudentService;
import com.neu.edu.utils.DB;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CourseServiceImpl implements CourseService {
    private CourseDao courseDao;
    public CourseServiceImpl(CourseDao courseDao){
        this.courseDao=courseDao;
    }
    public CourseServiceImpl(){}
    @Override
    public void addCourse(Course course) throws SQLException {
        courseDao.addCourse(course);
    }

    @Override
    public void deleteCourse(String id) throws SQLException {
        courseDao.deleteCourse(id);
    }

    @Override
    public void updateCourse(Course course) throws SQLException {
        courseDao.updateCourse(course);
    }

    @Override
    public Course getCourseById(String id) throws SQLException {
        return courseDao.getCourseById(id);
    }

    @Override
    public List<Course> getAllCourses() throws SQLException {
        return courseDao.getAllCourses();
    }
}
