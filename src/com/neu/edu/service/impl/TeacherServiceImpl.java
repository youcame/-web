package com.neu.edu.service.impl;

import com.neu.edu.dao.TeacherDao;
import com.neu.edu.po.Teacher;
import com.neu.edu.service.TeacherService;

import java.sql.SQLException;
import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    private TeacherDao teacherDao;
    public TeacherServiceImpl(TeacherDao teacherDao){
        this.teacherDao=teacherDao;
    }
    @Override
    public void addTeacher(Teacher teacher) throws SQLException {
        teacherDao.addTeacher(teacher);
    }

    @Override
    public void deleteTeacher(String id) throws SQLException {
        teacherDao.deleteTeacher(id);
    }

    @Override
    public void updateTeacher(Teacher teacher) throws SQLException {
        teacherDao.updateTeacher(teacher);
    }

    @Override
    public Teacher getTeacherById(String id) throws SQLException {
        return teacherDao.getTeacherById(id);
    }

    @Override
    public List<Teacher> getAllTeachers() throws SQLException {
        return teacherDao.getAllTeachers();
    }
    //登陆验证


}
