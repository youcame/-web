package com.neu.edu.servlet;

import com.neu.edu.dao.impl.ApprovalDaoImpl;
import com.neu.edu.po.Approval;
import com.neu.edu.service.ApprovalService;
import com.neu.edu.service.impl.ApprovalServiceImpl;
import com.neu.edu.utils.DB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

//用于二次审批结果的Servlet
@WebServlet(name = "SecondApprovalExamineServlet", value = "/SecondApprovalExamineServlet")
public class SecondApprovalExamineServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApprovalService approvalService = new ApprovalServiceImpl(new ApprovalDaoImpl(DB.getConnection()));
        String approvalId = request.getParameter("approvalId");
        String secondResult = request.getParameter("secondResult");
        try{
            if("null".equals(approvalId)&&"null".equals(secondResult)){
                List<Approval> approvalList = approvalService.getAllApprovals();
                request.setAttribute("approvalList",approvalList);
                request.getRequestDispatcher("examined_second_approval.jsp").forward(request,response);
            }
            approvalService.changeSecondApproval(approvalId, secondResult);
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
