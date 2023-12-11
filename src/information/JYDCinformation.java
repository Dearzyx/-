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

@WebServlet("/JYDCinformation")
public class JYDCinformation extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String sID = req.getParameter("sID");
        String gzdy = req.getParameter("gzdy");
        String dwxz = req.getParameter("dwxz");
        String sfsx = req.getParameter("sfsx");
        String bzsm = req.getParameter("bzsm");
        String gzdd = req.getParameter("gzdd");
        String qwxc = req.getParameter("qwxc");
        String zyxgd = req.getParameter("zyxgd");
        String qktj = req.getParameter("qktj");
        String name3 = (String) req.getSession().getAttribute("name");
        if (sID != null && gzdy != null && dwxz != null && sfsx != null && bzsm != null && gzdd != null
                && qwxc != null && zyxgd != null && qktj != null) {
            Connection conn = null;
            Statement stmt = null;
            try {
                conn = pojo.getConnection();
                stmt = conn.createStatement();
                String sql = "update  就业调查 set  sID ='" + sID + "',gzdy='" + gzdy + "',dwxz='" + dwxz + "',sfsx='" + sfsx + "',bzsm='" + bzsm + "',gzdd='" + gzdd + "'," +
                        "qwxc='" + qwxc + "',zyxgd='" + zyxgd + "',qktj='" + qktj + "' where sID=" + name3;
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
