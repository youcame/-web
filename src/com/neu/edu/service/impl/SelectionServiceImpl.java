package com.neu.edu.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.neu.edu.dao.SelectionDao;
import com.neu.edu.dao.impl.SelectionDaoImpl;
import com.neu.edu.po.Selection;
import com.neu.edu.service.SelectionService;
import com.neu.edu.utils.DB;

public class SelectionServiceImpl implements SelectionService {

    private SelectionDao selectionDao;

    public SelectionServiceImpl() {
        this.selectionDao = new SelectionDaoImpl(DB.getConnection());
    }

    @Override
    public List<Selection> getAllSelections() throws SQLException {
        return selectionDao.getAllSelections();
    }

    @Override
    public List<Selection> getSelectionsByStudentId(String studentId) throws SQLException {
        return selectionDao.getSelectionsByStudentId(studentId);
    }

    @Override
    public void addSelection(Selection selection) throws SQLException {
        selectionDao.addSelection(selection);
    }

    @Override
    public void updateSelection(Selection selection) throws SQLException {
        selectionDao.updateSelection(selection);
    }

    @Override
    public void deleteSelection(String studentId, String courseId) throws SQLException {
        selectionDao.deleteSelection(studentId, courseId);
    }
}
