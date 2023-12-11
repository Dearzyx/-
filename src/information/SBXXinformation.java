package information;

import pojo.pojo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

@WebServlet("/SBXXinformation")
public class SBXXinformation extends HttpServlet {
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
        if (sID != null && zydk != null && bdzbm != null && sxdazj != null && sxdajsr != null && sfqrzbk != null
                && dx != null && sxyx != null && sxyxyb != null && lqyx != null && jsr !=null && mtbks != null) {
            Connection conn = null;
            Statement stmt = null;
            try {
                conn = pojo.getConnection();
                stmt = conn.createStatement();
                String sql = "update  升本信息 set  sID ='" + sID + "',zydk='" + zydk + "',bdzbm='" + bdzbm + "',sxdazj='" + sxdazj + "',sxdajsr='" + sxdajsr + "',sfqrzbk='" + sfqrzbk + "'," +
                        "dx='" + dx + "',sxyx='" + sxyx + "',sxyxyb='" + sxyxyb + "',lqyx='" + lqyx + "',jsr='" + jsr + "',mtbks='" + mtbks + "' where sID=" + name3;
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
