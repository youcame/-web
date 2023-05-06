<%--
  Created by IntelliJ IDEA.
  User: HUANG
  Date: 2023/5/6
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>拒绝申请的原因</title>
    <link rel="stylesheet" type="text/css" href="reason.css">
</head>
<body>
<h2 align="center">填写选择原因</h2>
<form method="post" action="processReason.jsp">
    <input type="hidden" name="approvalId" value="${param.approvalId}">
    <div class="input-container" align="center">
        <textarea name="reason" rows="10" cols="50"></textarea>
    </div>
    <div class="button-container">
        <div>
            <input type="submit" value="提交">
        </div>
        <div>
            <input type="button" value="返回" onclick="window.history.back();">
        </div>
    </div>
</form>
</body>
</html>
