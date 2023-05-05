package com.neu.edu.servlet;

import com.neu.edu.dao.impl.ApprovalDaoImpl;
import com.neu.edu.service.ApprovalService;
import com.neu.edu.service.impl.ApprovalServiceImpl;
import com.neu.edu.utils.DB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "StudentApprovalServlet", value = "/StudentApprovalServlet")
public class StudentApprovalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApprovalService approvalService = new ApprovalServiceImpl(new ApprovalDaoImpl(DB.getConnection()));
        String approvalId = request.getParameter("approvalId");
        String state = request.getParameter("state");
        try {
            approvalService.changeStudentApproval(approvalId,state);
            request.getRequestDispatcher("ApprovalServlet").forward(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
