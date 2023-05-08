<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>用户信息修改</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
<div class="login-box">
    <h1>新增用户</h1>
    <form action="/Webapp_war_exploded/ModifyUserServlet" method="post">
        <div>
            <label for="type">用户类型:</label>
            <select id="type" name="type">
                <option value="student">学生</option>
                <option value="teacher">老师</option>
            </select>
        </div>
        <div>
            <label for="name">姓名:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div>
            <label for="id">ID:</label>
            <input type="text" id="id" name="id" required>
        </div>
        <div>
            <label for="password">密码:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <button type="submit">提交</button>
        <button type="button" onclick="window.history.back();">返回</button>
    </form>
</div>
</body>
</html>
