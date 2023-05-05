package com.neu.edu.test;

import com.neu.edu.dao.CourseDao;
import com.neu.edu.dao.impl.CourseDaoImpl;
import com.neu.edu.po.Course;
import com.neu.edu.utils.DB;
import org.junit.jupiter.api.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class ImplCourseTest {
    public static void main(String[] args) throws ParseException, SQLException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = "2023-04-04 15:20:00";
        CourseDao cd=new CourseDaoImpl(DB.getConnection());
        Course course=new Course("123","Math",dateString,"huang","true");
        //cd.addCourse(course);
        System.out.println(cd.getCourseById("123").getName());
    }
}
