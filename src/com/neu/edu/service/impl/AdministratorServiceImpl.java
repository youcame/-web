package com.neu.edu.service.impl;

import com.neu.edu.dao.AdministratorDao;
import com.neu.edu.dao.StudentDao;
import com.neu.edu.dao.TeacherDao;
import com.neu.edu.po.Administrator;
import com.neu.edu.po.Student;
import com.neu.edu.po.Teacher;
import com.neu.edu.service.AdministratorService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AdministratorServiceImpl implements AdministratorService {
    private AdministratorDao administratorDao;
    public AdministratorServiceImpl(AdministratorDao administratorDao){
        this.administratorDao = administratorDao;
    }
    @Override
    public List<Administrator> getAllAdministrators() throws SQLException {
        return administratorDao.getAllAdministrators();
    }
}
