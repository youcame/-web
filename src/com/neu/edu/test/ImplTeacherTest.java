package com.neu.edu.test;

import com.google.gson.Gson;
import com.neu.edu.dao.StudentDao;
import com.neu.edu.dao.impl.StudentDaoImpl;
import com.neu.edu.dao.impl.TeacherDaoImpl;
import com.neu.edu.po.Course;
import com.neu.edu.po.Student;
import com.neu.edu.po.Teacher;
import com.neu.edu.service.StudentService;
import com.neu.edu.service.TeacherService;
import com.neu.edu.service.impl.StudentServiceImpl;
import com.neu.edu.service.impl.TeacherServiceImpl;
import com.neu.edu.utils.DB;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImplTeacherTest {
    public static void main(String[] args) throws ParseException, SQLException {

        TeacherService teacherService = new TeacherServiceImpl(new TeacherDaoImpl(DB.getConnection()));
        for(Teacher teacher:teacherService.getAllTeachers()) {
            System.out.println(teacher.getPassword());
        }
    }
}
