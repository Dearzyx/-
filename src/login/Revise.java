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

@WebServlet("/revise")
public class Revise extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String ter1 = req.getParameter("revise1");
        String password;
        String usernaem;
        String username1 = req.getParameter("username1");
        String passwork1 = req.getParameter("passwork1");


        if (username1 == null && passwork1 == null) {
            resp.getWriter().println("输入的用户名或原密码为空");
        } else {
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            try {
                conn = pojo.getConnection();
                stmt = conn.createStatement();
                switch (ter1) {
                    case "学生":
                        String sql = "update login set password= '" + passwork1 + "' where username = '" + username1 + "'";
                        int a = stmt.executeUpdate(sql);
                        if (a >= 1) {
                            resp.getWriter().println("修改成功！");
                        }

                    case "教师教辅人员":

                        String sql1 = "update login2 set  password='" + passwork1 + "' where username = '" + username1 + "'";
                        int b = stmt.executeUpdate(sql1);
                        if (b >= 1) {
                            resp.getWriter().println("修改成功！");

                        }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
