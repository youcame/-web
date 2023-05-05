package com.neu.edu.test;

import com.neu.edu.dao.ApprovalDao;
import com.neu.edu.dao.impl.ApprovalDaoImpl;
import com.neu.edu.po.Approval;
import com.neu.edu.service.ApprovalService;
import com.neu.edu.service.impl.ApprovalServiceImpl;
import com.neu.edu.utils.DB;

import java.sql.SQLException;

public class ImplApprovalTest {
    public static void main(String[] args) throws SQLException {
        ApprovalService approvalService = new ApprovalServiceImpl(new ApprovalDaoImpl(DB.getConnection()));
        Approval approval=new Approval();
        approval = approvalService.getApprovalById("1092123");
        approval.setState("unapproved");
        approvalService.updateApproval(approval);
        System.out.println(approval.getState());

    }
}
