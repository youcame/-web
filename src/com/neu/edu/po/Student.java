package com.neu.edu.po;

import java.util.List;

public class Student {
    private String id;
    private String password;
    private String name;
    String chosenCourse;

    public Student(String id, String password, String name, String chosenCourse) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.chosenCourse = chosenCourse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChosenCourse() {
        return chosenCourse;
    }

    public void setChosenCourse(String chosenCourse) {
        this.chosenCourse = chosenCourse;
    }
}
