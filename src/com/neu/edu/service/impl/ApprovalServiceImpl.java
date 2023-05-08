package com.neu.edu.service.impl;

import com.neu.edu.dao.*;
import com.neu.edu.dao.impl.CourseDaoImpl;
import com.neu.edu.dao.impl.SelectionDaoImpl;
import com.neu.edu.dao.impl.StudentDaoImpl;
import com.neu.edu.dao.impl.TeacherDaoImpl;
import com.neu.edu.po.Approval;
import com.neu.edu.po.Selection;
import com.neu.edu.service.ApprovalService;
import com.neu.edu.service.CourseService;
import com.neu.edu.utils.DB;
import com.neu.edu.utils.MyDate;

import java.sql.SQLException;
import java.util.List;

public class ApprovalServiceImpl implements ApprovalService {
    private  ApprovalDao approvalDao;
    public ApprovalServiceImpl(ApprovalDao approvalDao){
        this.approvalDao=approvalDao;
    }

    public  ApprovalServiceImpl(){}
    @Override
    public void addApproval(Approval approval) throws SQLException {
        approvalDao.addApproval(approval);
    }

    @Override
    public void deleteApproval(String id) throws SQLException {
        approvalDao.deleteApproval(id);
    }

    @Override
    public void updateApproval(Approval approval) throws SQLException {
        approvalDao.updateApproval(approval);
    }

    @Override
    public Approval getApprovalById(String id) throws SQLException {
        return approvalDao.getApprovalById(id);
    }

    @Override
    public List<Approval> getAllApprovals() throws SQLException {
        return approvalDao.getAllApprovals();
    }

    @Override
    public void changeApproval(String approvalId, String result) throws SQLException {
        SelectionDao selectionDao = new SelectionDaoImpl(DB.getConnection());
        StudentDao studentDao = new StudentDaoImpl(DB.getConnection());
        TeacherDao teacherDao = new TeacherDaoImpl(DB.getConnection());
        CourseDao courseDao = new CourseDaoImpl(DB.getConnection());
        if(result.equals("Null")){
            Approval approval = approvalDao.getApprovalById(approvalId);
            approval.setResult(result);
            approval.setEndTime(MyDate.getDate());
            approval.setState("unapproved");
            approvalDao.updateApproval(approval);
            selectionDao.deleteSelection(approval.getStudentId(),courseDao.getCourseByName(approval.getCourseName()).getId());
        }
        else {
            Approval approval = approvalDao.getApprovalById(approvalId);
            approval.setResult(result);
            if(result.equals("true")){
                Selection selection = new Selection(approval.getId(),studentDao.getStudentById(approval.getStudentId()).getName(),
                        courseDao.getCourseByName(approval.getCourseName()).getId(),
                        approval.getStudentId(),teacherDao.getTeacherById(approval.getTeacherId()).getName(),approval.getCourseName());
                selectionDao.addSelection(selection);
            }
            approval.setState("end");
            approvalDao.updateApproval(approval);
        }
    }
    @Override
    public void changeStudentApproval(String approvalId, String state) throws SQLException{
        Approval approval = approvalDao.getApprovalById(approvalId);
        approval.setState(state);
        approval.setBeginTime(MyDate.getDate());
        approvalDao.updateApproval(approval);
    }

    @Override
    public void giveRejectReason(String approvalId, String reason) throws SQLException {
        Approval approval = approvalDao.getApprovalById(approvalId);
        approval.setRejectReason(reason);;
        approvalDao.updateApproval(approval);
    }
    @Override
    public void giveChooseReason(String approvalId, String reason) throws SQLException {
        Approval approval = approvalDao.getApprovalById(approvalId);
        approval.setChooseReason(reason);;
        approvalDao.updateApproval(approval);
    }
}
