package com.neu.edu.service;

import com.neu.edu.po.Administrator;

import java.sql.SQLException;
import java.util.List;

public interface AdministratorService {
    public List<Administrator> getAllAdministrators() throws SQLException;
}
