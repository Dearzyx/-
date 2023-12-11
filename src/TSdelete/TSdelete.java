package TSdelete;

import pojo.pojo;
import pojo.Searchdelete;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
@WebServlet("/TSdelete")
public class TSdelete extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //处理浏览器中文乱码
        String search = req.getParameter("search");
//        Searchdelete aa =new Searchdelete();
//       String search= aa.getSearch();
//        resp.getWriter().println("search="+search);
        if (req.getParameterNames()!=null) {
            Connection conn = null;
            Statement stmt = null;
                try {
                    conn = pojo.getConnection();
                    stmt = conn.createStatement();
                    String sql = "delete  from 学生个人信息 where username='"+search+"'";
                    int a = stmt.executeUpdate(sql);
                    if (a >= 1) {
                        resp.getWriter().println("删除成功！");
                    } else {
                        resp.getWriter().println("删除失败！");
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