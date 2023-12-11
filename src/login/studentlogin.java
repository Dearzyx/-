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
import java.util.ArrayList;
import java.util.List;

import pojo.student;

@WebServlet("/studentlogin")
public class studentlogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

//        获取表单信息
        String password = req.getParameter("password");
        String username = req.getParameter("username");
        String ter = req.getParameter("total");

        if (password != null && username != null) {
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            ResultSet rs1 = null;
            int lenght = password.length();
            int lenght2 = username.length();
            if (lenght==8 && lenght2==8) {
                try {
                    conn = pojo.getConnection();
                    stmt = conn.createStatement();
                    switch (ter) {
                        case "学生": {
                            String sql = "select*from login";
                            rs = stmt.executeQuery(sql);
                            List<student> list = new ArrayList<>();
                            while (rs.next()) {
                                student u = new student();
                                String username1 = rs.getString("username");
                                String password1 = rs.getString("password");
                                u.setUsername(username1);
                                u.setPassword(password1);
                                list.add(u);
                            }
                            int result = 0;
                            for (int i = 0; i < list.size(); i++) {
                                student u = list.get(i);
                                if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                                    System.out.println("登陆成功！");
                                    req.getSession().setAttribute("name", username);
                                    req.getRequestDispatcher("StudentIndex.jsp").forward(req, resp);
                                    return;
                                } else {
                                    result++;
                                }
                                if (result == list.size()) {
                                    resp.getWriter().println("用户名或密码错误！");
                                }
                            }
                        }
                        case "教师教辅人员": {
                            String sql = "select*from login2";
                            rs1 = stmt.executeQuery(sql);
                            List<student> list = new ArrayList<>();
                            while (rs1.next()) {
                                student u = new student();
                                String username1 = rs1.getString("username");
                                String password1 = rs1.getString("password");
                                u.setUsername(username1);
                                u.setPassword(password1);
                                list.add(u);
                            }
                            int result = 0;
                            for (int i = 0; i < list.size(); i++) {
                                student u = list.get(i);
                                if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                                    System.out.println("登陆成功！");
                                    req.getSession().setAttribute("name", username);
                                    req.getRequestDispatcher("TeacherIndex.jsp").forward(req, resp);
                                    return;
                                } else {
                                    result++;
                                }
                                if (result == list.size()) {
                                    resp.getWriter().println("用户名或密码错误！");
                                }
                            }
                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
