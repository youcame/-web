package com.neu.edu.servlet;

import com.mysql.cj.Session;
import com.neu.edu.dao.ApprovalDao;
import com.neu.edu.dao.SelectionDao;
import com.neu.edu.dao.StudentDao;
import com.neu.edu.dao.impl.ApprovalDaoImpl;
import com.neu.edu.dao.impl.SelectionDaoImpl;
import com.neu.edu.dao.impl.StudentDaoImpl;
import com.neu.edu.po.Selection;
import com.neu.edu.po.Student;
import com.neu.edu.service.SelectionService;
import com.neu.edu.service.StudentService;
import com.neu.edu.service.impl.ApprovalServiceImpl;
import com.neu.edu.service.impl.SelectionServiceImpl;
import com.neu.edu.service.impl.StudentServiceImpl;
import com.neu.edu.utils.DB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
//用于显示学生课表
@WebServlet(name = "CourseShowServlet", value = "/CourseShowServlet")
public class CourseShowServlet extends HttpServlet {
    private SelectionService selectionService;
    private StudentService studentService;
    public void init() throws ServletException {
        StudentDao studentDao = new StudentDaoImpl(DB.getConnection());
        studentService = new StudentServiceImpl(studentDao);
        selectionService = new SelectionServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");

            Student student = studentService.getStudentByName(username);
            if(student != null) {
                List<Selection> list = selectionService.getSelectionsByStudentId(student.getId());
                request.setAttribute("selectionList",list);
            }
            request.getRequestDispatcher("student_main.jsp").forward(request,response);
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
