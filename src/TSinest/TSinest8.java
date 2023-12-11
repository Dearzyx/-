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
@WebServlet("/TSinest8")
public class TSinest8 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String name= req.getParameter("name");
        String xingzhi = req.getParameter("xingzhi");
        String hangye = req.getParameter("hangye");
        String dwyoubian = req.getParameter("dwyoubian");
        String lianxiren = req.getParameter("lianxiren");
        String zhuzhijigou = req.getParameter("zhuzhijigou");
        String bumen = req.getParameter("bumen");
        String diqu = req.getParameter("diqu");
        String dizhi = req.getParameter("dizhi");
        String number = req.getParameter("number");
        String time = req.getParameter("time");
        String bdzleibie = req.getParameter("bdzleibie");
        String bddwmc = req.getParameter("bddwmc");
        String youbian = req.getParameter("youbian");
        String paiqiannumber = req.getParameter("paiqiannumber");
        String suozaidi = req.getParameter("suozaidi");
        String zhuanjidanwei = req.getParameter("zhuanjidianwei");
        String zhuanjidizhi = req.getParameter("zhuanjidizhi");
        String lururiqi = req.getParameter("lururiqi");
        String shuoming = req.getParameter("shuoming");
        String jiuyemanyidu = req.getParameter("jiuyemanyidu");
        String jiuyebiaozhi = req.getParameter("jiuyebiaozhi");
        String quxiang = req.getParameter("quxiang");
        String leibie = req.getParameter("leibie");
        String bing = req.getParameter("bing");
        String username = req.getParameter("username");

        if (req.getParameterNames() != null) {
            Connection conn = null;
            Statement stmt = null;
            try {
                conn = pojo.getConnection();
                stmt = conn.createStatement();
                String sql = "insert into 单位信息  (username,name,xingzhi,hangye,dwyoubian,lianxiren,zhuzhijigou,bumen,diqu,dizhi,number,time,bdzleibie,bddwmc,youbian,paiqiannumber,suozaidi,zhuanjidanwei,zhuanjidizhi,lururiqi,shuoming,jiuyemanyidu,jiuyebiaozhi,quxiang,leibie,bing) values ('" + username + "','" + name + "','" + xingzhi + "','" + hangye + "','" + dwyoubian + "','" + lianxiren + "','" + zhuzhijigou + "','" + bumen + "','" + diqu + "','" + dizhi + "','"
                        + number + "','" + time + "','" + bdzleibie + "','" + bddwmc + "','" + youbian + "','" + paiqiannumber + "','"
                        + suozaidi + "','" + zhuanjidanwei + "','" + zhuanjidizhi + "','" + lururiqi + "','" + shuoming + "','" +
                        jiuyemanyidu + "','" + jiuyebiaozhi + "','" + quxiang + "','" + leibie + "','" + bing + "')";;
                int a = stmt.executeUpdate(sql);
                if (a>=1){
                    resp.getWriter().println("插入成功！");
                }else {
                    resp.getWriter().println("插入失败！");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            resp.getWriter().println("输入内容不可为空！");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
