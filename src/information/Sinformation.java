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

@WebServlet("/Sinformation")
public class Sinformation extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String guanxi = req.getParameter("guanxi");
        String name1 = req.getParameter("name1");
        String sID = req.getParameter("sID");
        String number1 = req.getParameter("number1");
        String youbianma = req.getParameter("youbianma");
        String daimahao = req.getParameter("daimahao");
        String pinkun = req.getParameter("pinkun");
        String paichusuo = req.getParameter("paichusuo");
        String sheng = req.getParameter("sheng");
        String shi = req.getParameter("shi");
        String qu = req.getParameter("qu");
        String jiedao = req.getParameter("jiedao");
        String name3 = (String) req.getSession().getAttribute("name");
        if (req.getParameterNames() != null) {
            Connection conn = null;
            Statement stmt = null;
            try {
                conn = pojo.getConnection();
                stmt = conn.createStatement();
                String sql = "update 家庭信息 set sID='" + sID + "',guanxi='" + guanxi + "',name1='" +name1+ "',number1='" + number1 + "',youbianma='" + youbianma + "',daimahao='" + daimahao + "',pinkun='" + pinkun + "',paichusuo='" + paichusuo + "',sheng='" + sheng + "',shi='" + shi + "',qu='" + qu + "',jiedao='" + jiedao + "'where sID=" + name3;
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
            resp.getWriter().println("输入内容不可为空！");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
