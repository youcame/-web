<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="css/approval.css">
    <script type="application/javascript" src="js/my.js"></script>
    <title>管理员页面</title>
</head>
<body>
<div class="header">
    <h1>你好，<%=session.getAttribute("username")%>管理员</h1>
</div>

<div class="table-container">
    <h2 align="center">学生列表</h2>
    <table align="center" border="1">
        <tr>
            <th>学生id</th>
            <th>学生姓名</th>
            <th>学生密码</th>
        </tr>
        <c:forEach items="${studentList}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.password}</td>
            </tr>
        </c:forEach>
    </table>

    <h2 align="center">老师列表</h2>
    <table align="center" border="1">
        <tr>
            <th>老师id</th>
            <th>老师姓名</th>
            <th>老师密码</th>
        </tr>
        <c:forEach items="${teacherList}" var="teacher">
            <tr>
                <td>${teacher.id}</td>
                <td>${teacher.name}</td>
                <td>${teacher.password}</td>
            </tr>
        </c:forEach>
    </table>

    <h2 align="center">审批列表</h2>
    <table align="center" border="1">
        <tr>
            <th>申请id</th>
            <th>课程名称</th>
            <th>学生id</th>
            <th>老师id</th>
            <th>申请状态</th>
            <th>申请结果</th>
            <th>申请开始时间</th>
            <th>申请结束时间</th>
            <th>申请原因</th>
            <th>审批原因</th>>
        </tr>
        <c:forEach items="${approvalList}" var="approval">
            <c:if test="${approval.state.equals('end')}">
                <tr>
                    <td>${approval.id}</td>
                    <td>${approval.courseName}</td>
                    <td>${approval.studentId}</td>
                    <td>${approval.teacherId}</td>
                    <td>${approval.state}</td>
                    <td>${approval.result}</td>
                    <td>${approval.beginTime}</td>
                    <td>${approval.endTime}</td>
                    <td><input type="button" onclick="showReason('${approval.chooseReason}')" value="申请原因" /></td>
                    <c:if test="${approval.result.equals('false')}">
                        <td><input type="button" onclick="showReason('${approval.rejectReason}')" value="查看原因" /></td>
                    </c:if>
                    <c:if test="${approval.result.equals('true')}">
                        <td><input type="button" onclick="showCongratulation()" value="查看原因" /></td>
                    </c:if>
                </tr>
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
