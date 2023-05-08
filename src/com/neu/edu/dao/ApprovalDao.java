package com.neu.edu.dao;

import com.neu.edu.po.Approval;
import com.neu.edu.po.Student;

import java.sql.SQLException;
import java.util.List;

public interface ApprovalDao {
    public void addApproval(Approval approval) throws SQLException;
    public void deleteApproval(String id) throws SQLException;
    public void updateApproval(Approval approval) throws SQLException;
    public Approval getApprovalById(String id) throws SQLException;
    public List<Approval> getAllApprovals() throws SQLException;
    public List<Approval> getApprovalsByType(String type,String content,String studentId) throws  SQLException;
}
