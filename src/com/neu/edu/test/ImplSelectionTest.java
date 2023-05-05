package com.neu.edu.test;

import com.neu.edu.dao.SelectionDao;
import com.neu.edu.dao.impl.SelectionDaoImpl;
import com.neu.edu.service.SelectionService;
import com.neu.edu.service.impl.SelectionServiceImpl;
import com.neu.edu.utils.DB;

import java.sql.SQLException;

public class ImplSelectionTest {
    public static void main(String[] args) throws SQLException {

        SelectionService selectionService = new SelectionServiceImpl();
        System.out.println(selectionService.getAllSelections());
    }

}
