package com.neu.edu.servlet;

import com.mysql.cj.Session;
import com.neu.edu.dao.impl.ApprovalDaoImpl;
import com.neu.edu.service.ApprovalService;
import com.neu.edu.service.impl.ApprovalServiceImpl;
import com.neu.edu.utils.DB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
//要求教师给出拒绝理由的
@WebServlet(name = "GiveReasonServlet", value = "/GiveReasonServlet")
public class GiveReasonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reason = request.getParameter("reason");
        String approvalId = request.getParameter("approvalId");
        ApprovalService approvalService = new ApprovalServiceImpl(new ApprovalDaoImpl(DB.getConnection()));
        HttpSession session = request.getSession();
        String authority = (String) session.getAttribute("authority");
        try {
            if("teacher".equals(authority)) {
                approvalService.giveRejectReason(approvalId, reason);
            }
            if("student".equals(authority)){
                approvalService.giveChooseReason(approvalId,reason);
            }
            request.getRequestDispatcher("ApprovalServlet").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
