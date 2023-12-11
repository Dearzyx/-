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

@WebServlet("/TSinest7")
public class TSinest7 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String name1 = req.getParameter("name1");
        String guanxi = req.getParameter("guanxi");
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


        if (req.getParameterNames() != null) {
            Connection conn = null;
            Statement stmt = null;

            try {
                conn = pojo.getConnection();
                stmt = conn.createStatement();
                String sql = "insert  into 家庭信息 (name1,guanxi,sID,number1,youbianma,daimahao,pinkun,paichusuo,sheng,shi,qu,jiedao)values ('" + name1 + "','" + guanxi + "','" + sID + "','" + number1 + "','" + youbianma + "','" + daimahao + "','" + pinkun + "','" + paichusuo + "','" + sheng + "','" + shi + "','" + qu + "','" + jiedao + "')";
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
