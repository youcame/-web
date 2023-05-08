<%--
  Created by IntelliJ IDEA.
  User: HUANG
  Date: 2023/4/4
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="css/approval.css">
    <meta charset="UTF-8">
    <title>学生界面</title>
    <script type="application/javascript" src="js/my.js"></script>
</head>
<body>
<div class="header">
    <h2 align="center">欢迎登陆,<%=session.getAttribute("username")%>同学</h2>
    <h4 align="center">你的课表</h4>
</div>
<div class="table-container">
    <table align="center" border="1">
        <tr>
            <th>课程序号</th>
            <th>课程名称</th>
            <th>学生id</th>
            <th>学生姓名</th>
            <th>授课老师</th>
        </tr>
        <c:forEach items="${selectionList}" var="selection" varStatus="status">
                <tr>
                    <td>${status.index+1}</td>
                    <td>${selection.courseName}</td>
                    <td>${selection.studentId}</td>
                    <td>${selection.stuName}</td>
                    <td>${selection.teacherName}</td>
                </tr>
        </c:forEach>
    </table>
</div>
    <div class="button-container">
        <div><input type="button" onclick="checkApproval()" value="查看申请列表"/></div>
        <div><input type="button" onclick="logout()" value="退出登录"/></div>
    </div>
</body>
</html>
