<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生选课与教师审批系统</title>
    <link href="login.css" rel="stylesheet">
    <script type="text/javascript">
        if(window.location.href.indexOf("notLogin")!=-1){
            alert("您还没有登录喵~")
        }
        if(window.location.href.indexOf("noAuthority")!=-1){
            alert("您没有权限访问这个网页喵~")
        }
    </script>
</head>
<body>
<div class="login-box">
    <h1>选课与审批系统</h1>
    <form action="/Webapp_war_exploded/LoginServlet" method="post">
        <div>
            <label for="username">用户名:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div>
            <label for="password">密码:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <button type="submit">登录</button>
    </form>
</div>
</body>
</html>
