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

@WebServlet(name = "DeleteUserServlet", value = "/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String authority = request.getParameter("authority");
        StudentService studentService = new StudentServiceImpl(new StudentDaoImpl(DB.getConnection()));
        TeacherService teacherService = new TeacherServiceImpl(new TeacherDaoImpl(DB.getConnection()));
        try {
            if ("student".equals(authority)) {
                studentService.deleteStudent(id);
            }
            if ("teacher".equals(authority)) {
                teacherService.deleteTeacher(id);
            }
            request.getRequestDispatcher("AdministratorServlet").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
