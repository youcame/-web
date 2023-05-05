package com.neu.edu.po;

public class Selection {
    private String id;
    private String stuName;
    private String courseId;
    private String studentId;
    private String teacherName;
    private String courseName;

    public Selection(String id, String stuName, String courseId, String studentId, String teacherName, String courseName) {
        this.id = id;
        this.stuName = stuName;
        this.courseId = courseId;
        this.studentId = studentId;
        this.teacherName = teacherName;
        this.courseName = courseName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}

