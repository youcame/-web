package com.neu.edu.po;

import java.util.List;

public class Teacher {
    private String id;
    private String name;
    private String password;
    private String unApprovedCourse;
    public  Teacher(){}
    public Teacher(String id, String name, String password, String unApprovedCourse) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.unApprovedCourse = unApprovedCourse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUnApprovedCourse() {
        return unApprovedCourse;
    }

    public void setUnApprovedCourse(String unApprovedCourse) {
        this.unApprovedCourse = unApprovedCourse;
    }
}
