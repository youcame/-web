<%--
  Created by IntelliJ IDEA.
  User: HUANG
  Date: 2023/4/12
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="approval.css">
    <script type="application/javascript" src="js/my.js"></script>
    <title>申请请求</title>
</head>
<body>
<div class="header">
    <h1>你好，<%=session.getAttribute("username")%>同学</h1>
    <h2 align="center">可申请课程</h2>
</div>
<div class="table-container">
<table align="center" border="1">
    <tr>
        <th>申请id</th>
        <th>课程名称</th>
        <th>学生id</th>
        <th>老师id</th>
        <th>申请状态</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${list}" var="approval" varStatus="status">
        <c:if test = "${approval.state.equals('able')}">
            <tr>
                <td>${approval.id}</td>
                <td>${approval.courseName}</td>
                <td>${approval.studentId}</td>
                <td>${approval.teacherId}</td>
                <td>${approval.state}</td>
                <td><input type="button" value="选择" onclick="studentChooseApproval('${approval.id}')"/></td>
            </tr>
        </c:if>
    </c:forEach>
</table>
<h1 align="center">待审批列表</h1>
<table align="center" border="1">
    <tr>
        <th>申请id</th>
        <th>课程名称</th>
        <th>学生id</th>
        <th>老师id</th>
        <th>申请开始时间</th>
        <th>申请状态</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${list}" var="approval" varStatus="status">
        <c:if test = "${approval.state.equals('unapproved')}">
            <c:if test="${student.id.equals(approval.studentId)}">
                <tr>
                    <td>${approval.id}</td>
                    <td>${approval.courseName}</td>
                    <td>${approval.studentId}</td>
                    <td>${approval.teacherId}</td>
                    <td>${approval.beginTime}</td>
                    <td>${approval.state}</td>
                    <td><input type="button" value="撤销" onclick="studentUndoApproval('${approval.id}')"/></td>
                </tr>
            </c:if>
        </c:if>
    </c:forEach>
</table>

<h1 align="center">已审批列表</h1>
<table align="center" border="1">
    <tr>
        <th>申请id</th>
        <th>课程名称</th>
        <th>学生id</th>
        <th>老师id</th>
        <th>申请是否通过</th>
        <th>申请开始时间</th>
        <th>申请结束时间</th>
        <th>申请是否结束</th>
    </tr>
    <c:forEach items="${list}" var="approval" varStatus="status">
        <c:if test = "${approval.state.equals('end')}">
            <c:if test="${student.id.equals(approval.studentId)}">
                <tr>
                    <td>${approval.id}</td>
                    <td>${approval.courseName}</td>
                    <td>${approval.studentId}</td>
                    <td>${approval.teacherId}</td>
                    <td>${approval.result}</td>
                    <td>${approval.beginTime}</td>
                    <td>${approval.endTime}</td>
                    <td>${approval.state}</td>
                </tr>
            </c:if>
        </c:if>
    </c:forEach>
</table>
</div>
<div class="button-container">
    <div><input type="button" onclick="logout()" value="退出登录"/></div>
    <div><input type="button" onclick="back()" value="返回" /></div>
</div>
</body>
</html>
