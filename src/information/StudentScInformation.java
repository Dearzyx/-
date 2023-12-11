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
@WebServlet("/StudentScInformation")
public class StudentScInformation extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //处理浏览器中文乱码
        String sID = req.getParameter("sID");
        String School = req.getParameter("School");
        String yuanxi = req.getParameter("yuanxi");
        String sfdaima = req.getParameter("sfdaima");
        String bmdaima = req.getParameter("bmdaima");
        String fxname = req.getParameter("fxname");
        String yxdaima = req.getParameter("yxdaima");
        String szddaima = req.getParameter("szddaima");
        String name3 = (String) req.getSession().getAttribute("name");
        if (sID != null && School != null && yuanxi != null && sfdaima != null && bmdaima != null && fxname != null
                && yxdaima != null && szddaima != null) {
            Connection conn = null;
            Statement stmt = null;
            try {
                conn = pojo.getConnection();
                stmt = conn.createStatement();
                String sql = "update  学校信息 set  sID ='" + sID + "',School='" + School + "',yuanxi='" + yuanxi + "',sfdaima='" + sfdaima + "',bmdaima='" + bmdaima + "',fxname='" + fxname + "'," +
                        "yxdaima='" + yxdaima + "',szddaima='" + szddaima + "' where sID=" + name3;
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
