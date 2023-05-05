package com.neu.edu.test;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.neu.edu.dao.StudentDao;
import com.neu.edu.dao.impl.StudentDaoImpl;
import com.neu.edu.po.Course;
import com.neu.edu.po.Student;
import com.neu.edu.service.StudentService;
import com.neu.edu.service.impl.StudentServiceImpl;
import com.neu.edu.utils.DB;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImplStudentTest {

    public static void main(String[] args) throws ParseException, SQLException {

        StudentDao studentDao=new StudentDaoImpl(DB.getConnection());
        StudentService studentService= new StudentServiceImpl(studentDao);
        List<Course> list=new ArrayList<Course>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = "2023-04-04 15:20:00";
        Date date = formatter.parse(dateString);
        Course course=new Course("123","Math",dateString,"huang","true");
        Course course1=new Course("321","Chinese",dateString,"huang","true");
        list.add(course);
        list.add(course1);
        Gson gson=new Gson();
        String courseList = gson.toString();
        Student student1=new Student("123","yyyzzz","zhangsan",courseList);
        Student student2=new Student("312","123456","Lisi",courseList);
//        studentDao.addStudent(student1);
//        studentDao.addStudent(student2);
        System.out.println(studentService.getStudentByName("zhangsan").getId());
    }
}
