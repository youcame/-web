package com.neu.edu.servlet;

import com.neu.edu.dao.ApprovalDao;
import com.neu.edu.dao.impl.ApprovalDaoImpl;
import com.neu.edu.dao.impl.StudentDaoImpl;
import com.neu.edu.dao.impl.TeacherDaoImpl;
import com.neu.edu.po.Approval;
import com.neu.edu.po.Student;
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
import java.util.List;

@WebServlet(name = "ApprovalSearchServlet", value = "/ApprovalSearchServlet")
public class ApprovalSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentService studentService = new StudentServiceImpl(new StudentDaoImpl(DB.getConnection()));
        TeacherService teacherService = new TeacherServiceImpl(new TeacherDaoImpl(DB.getConnection()));
        String type = request.getParameter("type");
        String content = request.getParameter("content");
        if("teacherName".equals(type)){
            type = "teacherId";
            try {
                content = teacherService.getTeacherByName(content).getId();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        HttpSession session =request.getSession();
        String username = (String) session.getAttribute("username");
        ApprovalDao approvalDao = new ApprovalDaoImpl(DB.getConnection());
        try {
            Student student = studentService.getStudentByName(username);
            String studentId = student.getId();
            List<Approval> approvalList = approvalDao.getApprovalsByType(type,content,studentId);
            request.setAttribute("approvalList",approvalList);
            request.getRequestDispatcher("result.jsp").forward(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
