<%--
  Created by IntelliJ IDEA.
  User: HUANG
  Date: 2023/4/14
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>老师界面</title>
    <script type="application/javascript" src="js/my.js"></script>
</head>
<body>
    <h1 align="center">待审批的课程</h1>
    <table align="center" border="1">
        <tr>
            <th>申请id</th>
            <th>课程名称</th>
            <th>学生id</th>
            <th>老师id</th>
            <th>申请开始时间</th>
            <th>申请是否结束</th>
        </tr>
        <c:forEach items="${list}" var="approval" varStatus="status">
            <c:if test = "${approval.state.equals('unapproved')}">
                <tr>
                    <td>${approval.id}</td>
                    <td>${approval.courseName}</td>
                    <td>${approval.studentId}</td>
                    <td>${approval.teacherId}</td>
                    <td>${approval.beginTime}</td>
                    <td>${approval.state}</td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
    <div align="left">
        <input type="button" onclick="checkApproval()" value="查看申请列表"/>
    </div>
    <div align="right">
        <input type="button" onclick="logout()" value="退出登录"/>
    </div>
</body>
</html>
