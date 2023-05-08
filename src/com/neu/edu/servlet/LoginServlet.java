package com.neu.edu.servlet;

import com.mysql.cj.Session;
import com.neu.edu.dao.AdministratorDao;
import com.neu.edu.dao.impl.AdministratorDaoImpl;
import com.neu.edu.dao.impl.StudentDaoImpl;
import com.neu.edu.dao.impl.TeacherDaoImpl;
import com.neu.edu.po.Administrator;
import com.neu.edu.po.Student;
import com.neu.edu.po.Teacher;
import com.neu.edu.service.AdministratorService;
import com.neu.edu.service.StudentService;
import com.neu.edu.service.TeacherService;
import com.neu.edu.service.impl.AdministratorServiceImpl;
import com.neu.edu.service.impl.StudentServiceImpl;
import com.neu.edu.service.impl.TeacherServiceImpl;
import com.neu.edu.utils.DB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.*;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    StudentService studentService = new StudentServiceImpl(new StudentDaoImpl(DB.getConnection()));
    TeacherService teacherService = new TeacherServiceImpl(new TeacherDaoImpl(DB.getConnection()));
    AdministratorService administratorService = new AdministratorServiceImpl(new AdministratorDaoImpl(DB.getConnection()));
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        try {
            List<Teacher> teacherList = teacherService.getAllTeachers();
            List<Student> studentList = studentService.getAllStudents();
            List<Administrator> administratorList = administratorService.getAllAdministrators();
            for(Student student:studentList){
                if(student.getName().equals(username)){
                    if(student.getPassword().equals(password)){
                        session.setAttribute("username",username);
                        session.setAttribute("isLogin",true);
                        session.setAttribute("authority","student");
                        session.setAttribute("student", student);
                        request.getRequestDispatcher("CourseShowServlet").forward(request,response);
                    }
                    else{
                        request.getRequestDispatcher("Error.html").forward(request,response);
                    }
                    break;
                }
            }
            for(Teacher teacher:teacherList){
                if(teacher.getName().equals(username)){
                    if(teacher.getPassword().equals(password)){
                        session.setAttribute("username",username);
                        session.setAttribute("isLogin",true);
                        session.setAttribute("authority","teacher");
                        request.getRequestDispatcher("ApprovalServlet").forward(request,response);
                    }
                    else{
                        request.getRequestDispatcher("Error.html").forward(request,response);
                    }
                    break;
                }
            }
            for(Administrator administrator:administratorList){
                if(administrator.getName().equals(username)){
                    if(administrator.getPassword().equals(password)){
                        session.setAttribute("username",username);
                        session.setAttribute("isLogin",true);
                        session.setAttribute("authority","administrator");
                        request.getRequestDispatcher("AdministratorServlet").forward(request,response);
                    }
                    else{
                        request.getRequestDispatcher("Error.html").forward(request,response);
                    }
                    break;
                }
            }
            request.getRequestDispatcher("Error.html").forward(request,response);
            System.out.println("not exist");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
