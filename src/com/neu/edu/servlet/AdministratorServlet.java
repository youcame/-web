package com.neu.edu.servlet;

import com.neu.edu.dao.ApprovalDao;
import com.neu.edu.dao.StudentDao;
import com.neu.edu.dao.TeacherDao;
import com.neu.edu.dao.impl.ApprovalDaoImpl;
import com.neu.edu.dao.impl.StudentDaoImpl;
import com.neu.edu.dao.impl.TeacherDaoImpl;
import com.neu.edu.po.Approval;
import com.neu.edu.po.Student;
import com.neu.edu.po.Teacher;
import com.neu.edu.service.ApprovalService;
import com.neu.edu.service.StudentService;
import com.neu.edu.service.TeacherService;
import com.neu.edu.service.impl.ApprovalServiceImpl;
import com.neu.edu.service.impl.StudentServiceImpl;
import com.neu.edu.service.impl.TeacherServiceImpl;
import com.neu.edu.utils.DB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
//用于展示管理员的申请列表
@WebServlet(name = "AdministratorServlet", value = "/AdministratorServlet")
public class AdministratorServlet extends HttpServlet {
    private StudentService studentService;
    private TeacherService teacherService;
    private ApprovalService approvalService;

    public void init() throws ServletException {
        StudentDao studentDao = new StudentDaoImpl(DB.getConnection());
        studentService = new StudentServiceImpl(studentDao);
        TeacherDao teacherDao = new TeacherDaoImpl(DB.getConnection());
        teacherService = new TeacherServiceImpl(teacherDao);
        ApprovalDao approvalDao = new ApprovalDaoImpl(DB.getConnection());
        approvalService = new ApprovalServiceImpl(approvalDao);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Student> studentList = studentService.getAllStudents();
            List<Teacher> teacherList = teacherService.getAllTeachers();
            List<Approval> approvalList = approvalService.getAllApprovals();
            request.setAttribute("studentList", studentList);
            request.setAttribute("teacherList", teacherList);
            request.setAttribute("approvalList", approvalList);
            request.getRequestDispatcher("administrator_main.jsp").forward(request,response);
        } catch (SQLException e) {
            System.out.println("huang.error");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

