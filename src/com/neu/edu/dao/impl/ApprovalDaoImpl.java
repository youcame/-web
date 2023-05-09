package com.neu.edu.dao.impl;

import com.neu.edu.dao.ApprovalDao;
import com.neu.edu.po.Approval;
import com.neu.edu.utils.MyDate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApprovalDaoImpl implements ApprovalDao {
    private Connection connection;

    public ApprovalDaoImpl(Connection connection) {
        this.connection = connection;
    }
    @Override
    public void addApproval(Approval approval) throws SQLException {
        String sql = "INSERT INTO approval (id, studentId, teacherId, state, result, beginTime, endTime, courseName, confirm, secondResult) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, approval.getId());
        statement.setString(2, approval.getStudentId());
        statement.setString(3, approval.getTeacherId());
        statement.setString(4, approval.getState());
        statement.setString(5, approval.getResult());
        statement.setString(6, MyDate.getDate());
        statement.setString(7, approval.getEndTime());
        statement.setString(8,approval.getCourseName());
        statement.setString(9,approval.getConfirm());
        statement.setString(10,approval.getSecondResult());
        statement.executeUpdate();
    }

    @Override
    public void deleteApproval(String id) throws SQLException {
        String sql = "DELETE FROM approval WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, id);
        statement.executeUpdate();
    }

    @Override
    public void updateApproval(Approval approval) throws SQLException {
        String sql = "UPDATE approval SET studentId=?, teacherId=?, state=?, result=?, beginTime=?, endTime=?," +
                " courseName=?, chooseReason=?, rejectReason=?, confirm=?, secondResult=?  WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, approval.getStudentId());
        statement.setString(2, approval.getTeacherId());
        statement.setString(3, approval.getState());
        statement.setString(4, approval.getResult());
        statement.setString(5, approval.getBeginTime());
        statement.setString(6, approval.getEndTime());
        statement.setString(7, approval.getCourseName());
        statement.setString(8, approval.getChooseReason());
        statement.setString(9, approval.getRejectReason());
        statement.setString(10,approval.getConfirm());
        statement.setString(11,approval.getSecondResult());
        statement.setString(12, approval.getId());

        statement.executeUpdate();
    }

    @Override
    public Approval getApprovalById(String id) throws SQLException {
        String sql = "SELECT * FROM approval WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            Approval approval = new Approval();
            approval.setId(resultSet.getString("id"));
            approval.setStudentId(resultSet.getString("studentId"));
            approval.setTeacherId(resultSet.getString("teacherId"));
            approval.setState(resultSet.getString("state"));
            approval.setResult(resultSet.getString("result"));
            approval.setBeginTime(resultSet.getString("beginTime"));
            approval.setEndTime(resultSet.getString("endTime"));
            approval.setChooseReason(resultSet.getString("chooseReason"));
            approval.setRejectReason(resultSet.getString("rejectReason"));
            approval.setCourseName(resultSet.getString("courseName"));
            approval.setConfirm(resultSet.getString("confirm"));
            approval.setSecondResult(resultSet.getString("secondResult"));
            return approval;
        } else {
            return null;
        }
    }

    @Override
    public List<Approval> getAllApprovals() throws SQLException {
        List<Approval> approvals = new ArrayList<>();
        String sql = "SELECT * FROM approval";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Approval approval = new Approval();
            approval.setId(resultSet.getString("id"));
            approval.setStudentId(resultSet.getString("studentId"));
            approval.setTeacherId(resultSet.getString("teacherId"));
            approval.setState(resultSet.getString("state"));
            approval.setResult(resultSet.getString("result"));
            approval.setBeginTime(resultSet.getString("beginTime"));
            approval.setEndTime(resultSet.getString("endTime"));
            approval.setCourseName(resultSet.getString("courseName"));
            approval.setChooseReason(resultSet.getString("chooseReason"));
            approval.setRejectReason(resultSet.getString("rejectReason"));
            approval.setConfirm(resultSet.getString("confirm"));
            approval.setSecondResult(resultSet.getString("secondResult"));
            approvals.add(approval);
        }
        return approvals;
    }

    @Override
    public List<Approval> getApprovalsByType(String type, String content, String studentId) throws SQLException{
        List<Approval> approvals = new ArrayList<>();
        String sql = "SELECT * FROM approval WHERE ";
        if ("result".equals(type)) {
            sql += "result = ?";
        } else if ("teacherId".equals(type)) {
            sql += "teacherId = ?";
        } else if ("courseName".equals(type)) {
            sql += "courseName = ?";
        } else if("approvalId".equals(type)){
            sql += "id = ?";
        }
        sql += " AND studentId = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, content);
        statement.setString(2, studentId);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Approval approval = new Approval();
            approval.setId(resultSet.getString("id"));
            approval.setStudentId(resultSet.getString("studentId"));
            approval.setTeacherId(resultSet.getString("teacherId"));
            approval.setState(resultSet.getString("state"));
            approval.setResult(resultSet.getString("result"));
            approval.setBeginTime(resultSet.getString("beginTime"));
            approval.setEndTime(resultSet.getString("endTime"));
            approval.setCourseName(resultSet.getString("courseName"));
            approval.setChooseReason(resultSet.getString("chooseReason"));
            approval.setRejectReason(resultSet.getString("rejectReason"));
            approval.setSecondResult(resultSet.getString("secondResult"));
            approval.setConfirm(resultSet.getString("confirm"));
            approvals.add(approval);
        }
        return approvals;
    }

}
