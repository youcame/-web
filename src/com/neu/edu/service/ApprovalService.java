package com.neu.edu.service;

import com.neu.edu.po.Approval;

import java.sql.SQLException;
import java.util.List;

public interface ApprovalService {
    public void addApproval(Approval approval) throws SQLException;
    public void deleteApproval(String id) throws SQLException;
    public void updateApproval(Approval approval) throws SQLException;
    public Approval getApprovalById(String id) throws SQLException;
    public List<Approval> getAllApprovals() throws SQLException;
    public void changeApproval(String approvalId,String result) throws SQLException;
    void changeStudentApproval(String approvalId, String result) throws  SQLException;
    void giveRejectReason(String approvalId, String reason) throws SQLException;
    void giveChooseReason(String approvalId, String reason)throws SQLException;
    public void changeSecondApproval(String approvalId,String secondResult) throws  SQLException;
}
