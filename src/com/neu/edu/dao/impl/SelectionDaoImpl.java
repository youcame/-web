package com.neu.edu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neu.edu.dao.SelectionDao;
import com.neu.edu.po.Selection;

public class SelectionDaoImpl implements SelectionDao {
    private Connection connection;

    public SelectionDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Selection> getAllSelections() throws SQLException {
        List<Selection> selections = new ArrayList<>();
        String sql = "SELECT * FROM selection";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String studentId = resultSet.getString("studentId");
            String courseId = resultSet.getString("courseId");
            String stuName = resultSet.getString("stuName");
            String courseName = resultSet.getString("courseName");
            String teacherName = resultSet.getString("teacherName");
            String id = resultSet.getString("id");
            Selection selection = new Selection(id, stuName, courseId, studentId, teacherName, courseName);
            selections.add(selection);
        }
        return selections;
    }

    @Override
    public List<Selection> getSelectionsByStudentId(String studentId) throws SQLException {
        List<Selection> selections = new ArrayList<>();
        String sql = "SELECT * FROM selection WHERE studentId = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, studentId);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String courseId = resultSet.getString("courseId");
            String stuName = resultSet.getString("stuName");
            String courseName = resultSet.getString("courseName");
            String teacherName = resultSet.getString("teacherName");
            Selection selection = new Selection(id, stuName, courseId, studentId, teacherName, courseName);
            selections.add(selection);
        }
        return selections;
    }

    @Override
    public void addSelection(Selection selection) throws SQLException {
        String sql = "INSERT INTO selection (studentId, courseId, stuName, courseName, teacherName, id) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, selection.getStudentId());
        statement.setString(2, selection.getCourseId());
        statement.setString(3, selection.getStuName());
        statement.setString(4, selection.getCourseName());
        statement.setString(5, selection.getTeacherName());
        statement.setString(6,selection.getId());
        statement.executeUpdate();
    }

    @Override
    public void updateSelection(Selection selection) throws SQLException {
        String sql = "UPDATE selection SET stuName = ?, courseName = ?, teacherName = ? WHERE studentId = ? AND courseId = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, selection.getStuName());
        statement.setString(2, selection.getCourseName());
        statement.setString(3, selection.getTeacherName());
        statement.setString(4, selection.getStudentId());
        statement.setString(5, selection.getCourseId());
        statement.executeUpdate();
    }

    @Override
    public void deleteSelection(String studentId, String courseId) throws SQLException {
        String sql = "DELETE FROM selection WHERE studentId = ? AND courseId = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, studentId);
        statement.setString(2, courseId);
        statement.executeUpdate();
    }

}
