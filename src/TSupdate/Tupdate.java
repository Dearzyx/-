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
@WebServlet("/Tupdate")
public class Tupdate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //处理浏览器中文乱码
        String username = req.getParameter("username");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String idcard = req.getParameter("idcard");
        String csrq = req.getParameter("csrq");
        String tel = req.getParameter("tel");
        String mz = req.getParameter("mz");
        String zzmm = req.getParameter("zzmm");
        String qq = req.getParameter("qq");
        String jsdj = req.getParameter("jsdj");

        String name3 = (String) req.getSession().getAttribute("name");


        if (req.getParameterNames() != null) {
            Connection conn = null;
            Statement stmt = null;
            try {
                conn = pojo.getConnection();
                stmt = conn.createStatement();
                String sql = "update  老师个人信息 set  sex='" + sex + "',name ='" + name + "',idcard='" + idcard + "',csrq='" + csrq + "',mz='" + mz + "'," +
                        "tel='" + tel + "',zzmm='" + zzmm + "',jsdj='" + jsdj + "',qq='" + qq + "' where username=" + name3;
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
            resp.getWriter().println("输入内容为空！");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
