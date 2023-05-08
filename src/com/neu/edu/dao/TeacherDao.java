package com.neu.edu.dao;

import com.neu.edu.po.Student;
import com.neu.edu.po.Teacher;

import java.sql.SQLException;
import java.util.List;

public interface TeacherDao {
    public void addTeacher(Teacher teacher) throws SQLException;
    public void deleteTeacher(String id) throws SQLException;
    public void updateTeacher(Teacher teacher) throws SQLException;
    public Teacher getTeacherById(String id) throws SQLException;
    public List<Teacher> getAllTeachers() throws SQLException;
    public Teacher getTeacherByName(String name) throws SQLException;
}
