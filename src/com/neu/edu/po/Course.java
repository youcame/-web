package com.neu.edu.po;

import java.util.Date;

public class Course {
    private String name;
    private String date;
    private String teacherName;
    private String approval;
    private String id;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }

    public Course(String id,String name, String date, String teacherName, String approval) {
        this.id=id;
        this.name = name;
        this.date = date;
        this.teacherName = teacherName;
        this.approval = approval;
    }
}
