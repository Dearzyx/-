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
@WebServlet("/TSinest10")
public class TSinest10 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String sID = req.getParameter("sID");
        String zydk = req.getParameter("zydk");
        String bdzbm = req.getParameter("bdzbm");
        String sxdazj = req.getParameter("sxdazj");
        String sxdajsr = req.getParameter("sxdajsr");
        String sfqrzbk = req.getParameter("sfqrzbk");
        String dx = req.getParameter("dx");
        String sxyx = req.getParameter("sxyx");
        String sxyxyb = req.getParameter("sxyxyb");
        String lqyx = req.getParameter("lqyx");
        String jsr = req.getParameter("jsr");
        String mtbks = req.getParameter("mtbks");
        String name3 = (String) req.getSession().getAttribute("name");
        if (req.getParameterNames()!=null) {
            Connection conn = null;
            Statement stmt = null;
            try {
                conn = pojo.getConnection();
                stmt = conn.createStatement();
                String sql = "insert  into 升本信息 (sID,zydk,bdzbm,sxdazj,sxdajsr,sfqrzbk,dx,sxyx,sxyxyb,lqyx,jsr,mtbks) values ('" + sID + "','" + zydk + "','" + bdzbm + "','" + sxdazj + "','" + sxdajsr + "','" + sfqrzbk + "'," +
                        "'" + dx + "','" + sxyx + "','" + sxyxyb + "','" + lqyx + "','" + jsr + "','" + mtbks + "') ";
                int a = stmt.executeUpdate(sql);
                if (a >= 1) {
                    resp.getWriter().println("插入成功！");
                } else {
                    resp.getWriter().println("插入失败！");
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