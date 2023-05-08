<%--
  Created by IntelliJ IDEA.
  User: HUANG
  Date: 2023/5/8
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>审批记录查询</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
<div class="login-box">
    <h1>审批记录查询</h1>
    <form action="/Webapp_war_exploded/ApprovalSearchServlet" method="post">
        <label for="type">查询条件:</label>
        <select id="type" name="type">
            <option value="approvalId">申请id</option>
            <option value="teacherId">老师id</option>
            <option value="teacherName">老师姓名</option>
            <option value="result">通过与否(true or false)</option>
            <option value="courseName">课程名称</option>
        </select>
        <label for="content">查询内容:</label>
        <input type="text" id="content" name="content" placeholder="请输入查询内容">
        <div>
            <button type="submit">提交</button>
            <button type="button" onclick="window.history.back();">返回</button>
        </div>
    </form>
</div>
</body>
</html>
