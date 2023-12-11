<%--
  Created by IntelliJ IDEA.
  User: Dear  Xin
  Date: 2022/10/6
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="css/StudentLeft.css">
</head>
<body>
<div class="nav">
    <div class="nav-list">
        <div class="nav-tit">
            <a href="StatisticalFigure.jsp" target="main">
                <img src="images/personal-msg.png" style="height: 30px" alt="">
                <span>统计图</span>
            </a>
        </div>
        <div class="nav-tit">
            <a href="TeacherPersonalInfo.jsp" target="main">
                <img src="images/archives-msg.png" alt="">
                <span>个人信息</span>
            </a>
        </div>
        <div class="nav-tit">
            <a href="Tearcherinfo2.jsp" target="main">
                <img src="images/PubMed-msg.png" alt="">
                <span>学生信息录入</span>
            </a>

        </div>
        <div class="nav-tit" id="personal">
            <a href="StudentInfo.jsp" target="main">
                <img src="images/PubMed-msg.png" alt="">
                <span>学生信息查看</span>
            </a>
        </div>
        <div class="nav-tit">
            <a href="/Tearcherinfo3.jsp" target="main">
                <img src="images/PubMed-msg.png" alt="">
                <span>学生信息编辑</span>
            </a>
        </div>
<%--        <div class="personal-list" id="personal_child">--%>
<%--            <ul>--%>
<%--&lt;%&ndash;                <li><a href="FamilyInformation2.jsp" target="main">学生学校信息</a></li>&ndash;%&gt;--%>
<%--                <li><a href="" target="main">学生学籍信息</a></li>--%>
<%--                <li><a href="" target="main">学生档案信息</a></li>--%>
<%--                <li><a href="" target="main">学生处分信息</a></li>--%>
<%--            </ul>--%>
<%--        </div>--%>
        <div class="nav-tit">
            <a href="StudentRevise.jsp" target="main">
                <img src="images/modify-password.png" alt="">
                <span>账户管理</span>
            </a>
        </div>
        <div class="nav-tit">
            <a href="search.jsp" target="main">
                <img src="images/soso-white.png" alt="">
                <span>搜索</span>
            </a>
        </div>
        <div class="nav-tit">
            <a href="/logout"  target="_top" >
                <img src="images/modify-password.png" alt="">
                <span>安全退出</span>
            </a>
        </div>
    </div>
</div>

<script src="js/jquery-1.9.1.min.js" type="text/javascript" charset="utf-8"></script>
<script>
    $(document).ready(function () {
        $('#personal').on('click', function () {
            $('#personal_child').fadeToggle(500);
        });
        let aLi = $('#personal_child li');
        aLi.on('click', function () {
            $(this).addClass('active').siblings('li').removeClass('active');
        })
    });
</script>
</body>
</html>

