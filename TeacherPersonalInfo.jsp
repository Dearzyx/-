<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Dear  Xin
  Date: 2022/10/6
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/TeacherPersonalInfo.css">
</head>
<body>
<%
    Object name = request.getSession().getAttribute("name");
%>
<%
    //驱动程序名
    String driverName = "com.mysql.cj.jdbc.Driver";
    //数据库用户名
    String userName = "root";
    //密码
    String userPasswd = "123456";
    //数据库名
    String dbName = "login";
    //联结字符串
    String url = "jdbc:mysql://localhost:3306/" + dbName + "?user="
            + userName + "&password=" + userPasswd;
    Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
    Connection connection = DriverManager.getConnection(url);
    Statement statement = connection.createStatement();
    String sql = "SELECT * FROM 老师个人信息 Where username=" + name;
    ResultSet rs = statement.executeQuery(sql);
%>
<div class="container flgure">
    <form method="post" action="/Tupdate">

            <%
        while (rs.next()) {
    %>
        <div class="content">
            <ul class="clearfix info">
                <li class="active">基础信息</li>
                <%--            <li>联系方式</li>--%>
            </ul>
            <div class="basic">
                <div class="select active">
                    <input type="submit" value="保存"
                           style="height:25px;width:40px;float:right;margin-right:0px;background-color: #82b6d7;color: #FFFFFF;font-size: 14px;border: none ">
                    <div class="left fl">
                        <div>
                            <label for="">姓名：</label>
                            <input type="text" value="<%out.print(rs.getString("name"));%>" name="name">
                        </div>
                        <div>
                            <label for="">性别：</label>
                            <input type="text" value="<%out.print(rs.getString("sex"));%>" name="sex">
                        </div>
                        <div>
                            <label for="">出生日期：</label>
                            <input type="text" value="<%out.print(rs.getString("csrq"));%>" name="csrq">
                        </div>
                        <div>
                            <label for="">身份证号：</label>
                            <input type="text" value="<%out.print(rs.getString("idcard"));%>" class="id" name="idcard">
                        </div>
                        <div>
                            <label for="">手机号码：</label>
                            <input type="text" value="<%out.print(rs.getString("tel"));%>" name="tel">
                        </div>
                    </div>
                    <div class="right fr">
                        <div>
                            <label for="">工号：</label>
                            <input type="text" value="<%out.print(rs.getString("username"));%>" name="username">
                        </div>
                        <div>
                            <label for="">民族：</label>
                            <input type="text" value="<%out.print(rs.getString("mz"));%>" name="mz">
                        </div>
                        <div class="label">
                            <label for="">政治面貌：</label>
                            <input type="text" value="<%out.print(rs.getString("zzmm"));%>" name="zzmm">
                        </div>
                        <div class="label">
                            <label for="">教师等级：</label>
                            <input type="text" value="<%out.print(rs.getString("jsdj"));%>" name="jsdj">
                        </div>
                        <div class="label">


                            <label for="">QQ号码：</label>
                            <input type="text" value="<%out.print(rs.getString("qq"));%>" name="qq">

                        </div>
                    </div>

                </div>
                <%--            <div class="select ">--%>
                <%--                <p>--%>
                <%--                    <span>编辑</span>--%>
                <%--                    <span style="margin-left: 20px">保存</span>--%>
                <%--                </p>--%>

                <%--                <div class="right fr">--%>

                <%--                    <div>--%>
                <%--                        <label for="">电子邮箱：</label>--%>
                <%--                        <input type="email" value="">--%>
                <%--                    </div>--%>


                <%--                </div>--%>

                <%--            </div>--%>
                <%--            <div class="list list1 fl "><label>家庭地址</label> : <input type="text" value=""  name="username" style="width: 78px;"/> 省 <input type="text" value="" name="username" style="width: 98px;"/> 市 <input type="text" value=""  name="username" style="width: 98px;"/> 区/县 <input type="text" value="" name="username" style="width: 98px;"/> 街道 <input type="text" value="" name="username" style="width: 234px; margin: 30px 0 0 79px"/></div>--%>
            </div>
        </div>
            <%
        }
    %>
            <%
        rs.close();
        statement.close();
        connection.close();
    %>
</div>
</form>
</div>
<script src="js/jquery-1.9.1.min.js"></script>
<script>
    $('.info li').click(function () {
        $(this).addClass("active").siblings().removeClass("active");
        $('.basic .select').eq($("ul li").index(this)).addClass("active").siblings().removeClass("active")
    })
</script>
</body>
</html>
