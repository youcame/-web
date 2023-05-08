package com.neu.edu.servlet;

import com.neu.edu.dao.impl.StudentDaoImpl;
import com.neu.edu.dao.impl.TeacherDaoImpl;
import com.neu.edu.po.Student;
import com.neu.edu.po.Teacher;
import com.neu.edu.service.StudentService;
import com.neu.edu.service.TeacherService;
import com.neu.edu.service.impl.StudentServiceImpl;
import com.neu.edu.service.impl.TeacherServiceImpl;
import com.neu.edu.utils.DB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
//用于新增用户
@WebServlet(name = "ModifyUserServlet", value = "/ModifyUserServlet")
public class ModifyUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        StudentService studentService = new StudentServiceImpl(new StudentDaoImpl(DB.getConnection()));
        TeacherService teacherService = new TeacherServiceImpl(new TeacherDaoImpl(DB.getConnection()));
        try {
            if ("student".equals(type)) {
                Student student = new Student(id, password, name, null);
                studentService.addStudent(student);
            }
            if("teacher".equals(type)){
                System.out.println(type);
                Teacher teacher = new Teacher(id,name,password,null);
                teacherService.addTeacher(teacher);
            }
            request.getRequestDispatcher("AdministratorServlet").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
