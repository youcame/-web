package com.neu.edu.service.impl;

import com.neu.edu.dao.StudentDao;
import com.neu.edu.po.Student;
import com.neu.edu.service.StudentService;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;
    public StudentServiceImpl(StudentDao studentDao){
        this.studentDao=studentDao;
    }
    @Override
    public void addStudent(Student student) throws SQLException {
        studentDao.addStudent(student);
    }

    @Override
    public void deleteStudent(String id) throws SQLException {
        studentDao.deleteStudent(id);
    }

    @Override
    public void updateStudent(Student student) throws SQLException {
        studentDao.updateStudent(student);
    }

    @Override
    public Student getStudentById(String id) throws SQLException {
        return studentDao.getStudentById(id);
    }

    @Override
    public List<Student> getAllStudents() throws SQLException {
        return studentDao.getAllStudents();
    }

    @Override
    public Student getStudentByName(String name) throws SQLException {
        return studentDao.getStudentByName(name);
    }
}
