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
    <link rel="stylesheet" href="css/approval.css">
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
        <th>申请原因</th>
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
                    <td><input type="button" value="申请原因" onclick="showReason('${approval.chooseReason}')"/></td>
                    <td><input type="button" value="撤销" onclick="studentUndoApproval('${approval.id}')"/></td>
                </tr>
            </c:if>
        </c:if>
    </c:forEach>
</table>
<input type="button" class="centered-button" onclick="goSearch()" value="查询历史申请">
<h1 align="center">已审批列表</h1>
<table align="center" border="1">
    <tr>
        <th>申请id</th>
        <th>课程名称</th>
        <th>学生id</th>
        <th>老师id</th>
        <th>一审结果</th>
        <th>二审结果</th>
        <th>申请开始时间</th>
        <th>申请结束时间</th>
        <th>申请原因</th>
        <th>审批原因</th>
        <th>确认</th>
    </tr>
    <c:forEach items="${list}" var="approval" varStatus="status">
        <c:if test = "${approval.state eq 'end' and approval.confirm ne 'true'}">
            <c:if test="${student.id.equals(approval.studentId)}">
                <tr>
                    <td>${approval.id}</td>
                    <td>${approval.courseName}</td>
                    <td>${approval.studentId}</td>
                    <td>${approval.teacherId}</td>
                    <td>${approval.result}</td>
                    <td>${approval.secondResult}</td>
                    <td>${approval.beginTime}</td>
                    <td>${approval.endTime}</td>
                    <td><input type="button" value="申请原因" onclick="showReason('${approval.chooseReason}')"/></td>
                    <c:if test="${approval.result.equals('false')}">
                        <td><input type="button" onclick="showReason('${approval.rejectReason}')" value="查看原因" /></td>
                    </c:if>
                    <c:if test="${approval.result.equals('true')}">
                        <td><input type="button" onclick="showCongratulation()" value="申请成功" /></td>
                    </c:if>
                    <td><input type="button" onclick="confirmChoice('${approval.id}')" value="确认无误"></td>
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
