<%--
  Created by IntelliJ IDEA.
  User: Dear  Xin
  Date: 2022/10/6
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/zhuce.css"/>
    <script src="js/jquery-1.9.1.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<div class="login">
    <div class="content clearfix">
        <div class="content-left">
            <div class="logo">
                <img style="width: 180px;height: 180px" src="images/logo.png"/>
                <p>学生就业信息管理系统</p>
            </div>
        </div>
        <div class="shu"></div>
        <div class="content-right">
            <div class="login-form">
                <form action="/studentlogon" method="post">
                    <h2>注册</h2>
                    <div class="identifire">
                        <span>身　份：</span>
                        <select name="total" style="width: 240px;height: 35px; border-radius: 5px;">
                            <option selected="selected">学生</option>
                            <option>教师教辅人员</option>
                        </select>
                    </div>
                    <div class="identifire">
                        <span>用户名：</span>
                        <input type="text" name="username"/>
                    </div>
                    <div class="password clearfix">
                        <span>密&emsp;码：</span>
                        <input type="password" name="password"/>
                    </div>
                    <div class="password clearfix">

                        <input type="submit" value="注册" style="margin: 0 0  0 80px;color: #fff;background-color: #4fadeb">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

