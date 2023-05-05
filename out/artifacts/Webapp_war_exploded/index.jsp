<%--
  Created by IntelliJ IDEA.
  User: HUANG
  Date: 2023/3/25
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    <c:if test="${1 > 0}">
        <p>1是正数</p>
    </c:if>
    <c:out value="你不好"/>
</body>
</html>
