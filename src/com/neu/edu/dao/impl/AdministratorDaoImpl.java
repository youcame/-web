package com.neu.edu.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.neu.edu.dao.AdministratorDao;
import com.neu.edu.po.Administrator;

public class AdministratorDaoImpl implements AdministratorDao {
    private Connection connection;

    public AdministratorDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Administrator getAdministratorById(String id) throws SQLException {
        Administrator administrator = null;
        String sql = "SELECT * FROM administrator WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String password = resultSet.getString("password");
            String name = resultSet.getString("name");
            administrator = new Administrator(id, password, name);
        }
        return administrator;
    }
    @Override
    public List<Administrator> getAllAdministrators() throws SQLException {
        List<Administrator> administrators = new ArrayList<>();
        String sql = "SELECT * FROM administrator";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String password = resultSet.getString("password");
            Administrator administrator = new Administrator(id, name, password);
            administrators.add(administrator);
        }
        return administrators;
    }


    @Override
    public void addAdministrator(Administrator administrator) throws SQLException {
        String sql = "INSERT INTO administrator (id, password, name) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, administrator.getId());
        statement.setString(2, administrator.getPassword());
        statement.setString(3, administrator.getName());
        statement.executeUpdate();
    }

    @Override
    public void updateAdministrator(Administrator administrator) throws SQLException {
        String sql = "UPDATE administrator SET password = ?, name = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, administrator.getPassword());
        statement.setString(2, administrator.getName());
        statement.setString(3, administrator.getId());
        statement.executeUpdate();
    }

    @Override
    public void deleteAdministrator(String id) throws SQLException {
        String sql = "DELETE FROM administrator WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, id);
        statement.executeUpdate();
    }
}
