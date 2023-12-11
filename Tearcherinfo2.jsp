<%--
  Created by IntelliJ IDEA.
  User: Dear  Xin
  Date: 2022/10/6
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/StudentInfo.css"/>
</head>
<body>
<div class="container flgure">
    <div class="content">
        <ul class="clearfix info">
            <%--            <li>统计</li>--%>
            <li>学生个人基本信息</li>
            <li>学生家庭基本信息</li>
            <li>学生就业信息</li>
            <li>学生就业调查</li>
            <li>学生升本信息</li>
        </ul>

<%--        <jsp:include page="6.jsp" flush="true"/>--%>
        <div class="basic">
            <div class="provinceInfo1 select">
                <jsp:include page="6.jsp" flush="true"/>
            </div>
            <div class="employmentInfo2 select">
                <jsp:include page="7.jsp" flush="true"/>
            </div>
            <div class="employmentInfo3 select">
                <jsp:include page="8.jsp" flush="true"/>
            </div>
            <div class="employmentInfo4 select">
                <jsp:include page="9.jsp" flush="true"/>
            </div>
            <div class="employmentInfo5 select">
                <jsp:include page="10.jsp" flush="true"/>
            </div>
        </div>
    </div>
</div>

<script src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
    $('.info li').click(function () {
        $(this).addClass("active").siblings().removeClass("active");
        // $('.basic .select').eq($("ul li").index(this)).addClass("active").siblings().removeClass("active")
        $('.basic .select').eq($(this).index()).fadeIn().siblings().fadeOut()
    });
</script>
</body>
</html>

