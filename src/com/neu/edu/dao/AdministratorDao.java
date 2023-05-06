package com.neu.edu.dao;

import com.neu.edu.po.Administrator;
import com.neu.edu.po.Student;

import java.sql.SQLException;
import java.util.List;

public interface AdministratorDao {
    public void addAdministrator(Administrator student) throws SQLException;
    public void deleteAdministrator(String id) throws SQLException;
    public void updateAdministrator(Administrator administrator) throws SQLException;
    public Administrator getAdministratorById(String id) throws SQLException;
    public List<Administrator> getAllAdministrators() throws SQLException;
}
