package login;

import pojo.pojo;

import javax.servlet.ServletException;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/studentlogon")
public class studentlogon extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String ter = req.getParameter("total");
//        获取表单信息
        String password = req.getParameter("password");
        String username = req.getParameter("username");

        if (password != null && username != null) {
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            int length = password.length();
            int length2 = username.length();
            if (length==8  && length2==8) {
                try {
                    conn = pojo.getConnection();
                    stmt = conn.createStatement();
                    switch (ter) {
                        case "学生":
                            String sql = "insert into login values ('" + username + "','" + password + "')";
                            int i = stmt.executeUpdate(sql);

                            if (i >= 1) {
                                System.out.println("注册成功！");
                                resp.getWriter().println("注册成功！");
                            }
                        case "教师教辅人员":
                            String sql1 = "insert into login2 values ('" + username + "','" + password + "')";
                            var a = stmt.executeUpdate(sql1);
                            a = a;
                            if (a >= 1) {
                                System.out.println("注册成功！");
                                resp.getWriter().println("注册成功！");
                            }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                resp.sendRedirect("/Login.jsp");
            }else {
                resp.getWriter().println("输入内容必须为8位，请重新输入！");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
