package com.neu.edu.dao;

import com.neu.edu.po.Selection;

import java.sql.SQLException;
import java.util.List;

public interface SelectionDao {
    List<Selection> getAllSelections() throws SQLException;
    List<Selection> getSelectionsByStudentId(String studentId) throws SQLException;
    void addSelection(Selection selection) throws SQLException;
    void updateSelection(Selection selection) throws SQLException;
    void deleteSelection(String studentId, String courseId) throws SQLException;
}

