package TSupdate;

import pojo.pojo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
@WebServlet("/TSupdate1")
public class TSupdate1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //处理浏览器中文乱码
        String name1 = req.getParameter("name1");
        String sex = req.getParameter("sex");
        String csdate = req.getParameter("csdate");
        String idcard = req.getParameter("idcard");
        String username = req.getParameter("username");
        String minzhu = req.getParameter("minzhu");
        String zzmm = req.getParameter("zzmm");
        String dszn = req.getParameter("dszn");
        String phone = req.getParameter("phone");
        String qq = req.getParameter("qq");
        String email = req.getParameter("email");
        String name2 = req.getParameter("name2");
        String tel2 = req.getParameter("tel2");


        if (req.getParameterNames() != null) {
            Connection conn = null;
            Statement stmt = null;
            int legth = email.length();
            int legth2 = qq.length();
            int legth3 = phone.length();
            int idcardlg = idcard.length();
            int legth5 = tel2.length();
            if (idcardlg == 18) {
                try {
                    conn = pojo.getConnection();
                    stmt = conn.createStatement();
                    String sql = "update  学生个人信息 set  name1 ='" + name1 + "',sex='" + sex + "',csdate='" + csdate + "',idcard='" + idcard + "',username='" + username + "',minzhu='" + minzhu + "'," +
                            "minzhu='" + minzhu + "',zzmm='" + zzmm + "',dszn='" + dszn + "',phone='" + phone + "',qq='" + qq + "',email='" + email + "',name2='" + name2 + "',tel2='" + tel2 + "' where username=" + username;
                    int a = stmt.executeUpdate(sql);
                    if (a >= 1) {
                        resp.getWriter().println("修改成功！");
                    } else {
                        resp.getWriter().println("结果为空，请联系管理员录入信息！");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                resp.getWriter().println("请输入18的身份证号码！");
            }


        } else {
            resp.getWriter().println("输入内容为空！");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}