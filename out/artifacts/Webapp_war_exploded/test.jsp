<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP foreach Example</title>
</head>
<body>
<%
    String[] var = {"one", "two", "three"};
    pageContext.setAttribute("variables", var);
%>
<c:forEach var="item" items="${variables}">
    <p>${item}</p>
</c:forEach>
</body>
</html>