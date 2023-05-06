package com.neu.edu.servlet;

import com.mysql.cj.Session;
import com.neu.edu.dao.ApprovalDao;
import com.neu.edu.dao.impl.ApprovalDaoImpl;
import com.neu.edu.po.Approval;
import com.neu.edu.service.ApprovalService;
import com.neu.edu.service.impl.ApprovalServiceImpl;
import com.neu.edu.utils.DB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//用于展示学生与老师的所有申请
@WebServlet(name = "ApprovalServlet", value = "/ApprovalServlet")
public class ApprovalServlet extends HttpServlet {
    private ApprovalService approvalService;


    public void init() throws ServletException {
        ApprovalDao approvalDao = new ApprovalDaoImpl(DB.getConnection());
        approvalService = new ApprovalServiceImpl(approvalDao);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");
            String authority = (String) session.getAttribute("authority");
            List<Approval> list = approvalService.getAllApprovals();
            request.setAttribute("authority", authority);
            request.setAttribute("list", list);
            if (authority.equals("teacher")){
                request.getRequestDispatcher("teacher_approval_list.jsp").forward(request, response);
            }
            if(authority.equals("student")){
                request.getRequestDispatcher("student_approval_list.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
