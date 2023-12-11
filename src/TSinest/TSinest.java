package TSinest;

import pojo.pojo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
@WebServlet("/TSinest")
public class TSinest extends HttpServlet {
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



        if (req.getParameterNames()!=null) {
            Connection conn = null;
            Statement stmt = null;

                try {
                    conn = pojo.getConnection();
                    stmt = conn.createStatement();
                    String sql = "insert  into 学生个人信息 values ('" + name1 + "','" + sex + "','" + csdate + "','" + idcard + "','" + username + "','" + minzhu + "','" + zzmm + "','" + dszn + "','" + phone + "','" + qq + "','" + email + "','" + name2 + "','" + tel2 + "')";
                    int a = stmt.executeUpdate(sql);
                    if (a >= 1) {
                        resp.getWriter().println("添加成功！");
                    } else {
                        resp.getWriter().println("添加失败！");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
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
