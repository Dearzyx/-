package TSinest;

import com.alibaba.fastjson.JSON;
import pojo.pojo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import pojo.StudentInfo;

@WebServlet("/search")
public class Search extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        String searchContent = req.getParameter("searchContent");
        System.out.println(searchContent);

        if (searchContent!=null) {

            try {
                Connection conn = pojo.getConnection();
                Statement stmt = conn.createStatement();
                String sql="select * from 学生个人信息 where username ="+searchContent;
                ResultSet resultSet = stmt.executeQuery(sql);
                boolean next = resultSet.next();
                StudentInfo studentInfo = new StudentInfo();
                if (next){
                    String name = resultSet.getString(1);
                    studentInfo.setName1(name);
                    String sex =resultSet.getString(2);
                    studentInfo.setSex(sex);
                    String csdate =resultSet.getString(3);
                    studentInfo.setCsdate(csdate);
                    String idcard =resultSet.getString(4);
                    studentInfo.setIdcard(idcard);
                    String username =resultSet.getString(5);
                    studentInfo.setUsername(username);
                    String minzhu =resultSet.getString(6);
                    studentInfo.setMinzhu(minzhu);
                    String zzmm =resultSet.getString(7);
                    studentInfo.setZzmm(zzmm);
                    String dszn =resultSet.getString(8);
                    studentInfo.setDszn(dszn);
                    String phone =resultSet.getString(9);
                    studentInfo.setPhone(phone);
                    String qq =resultSet.getString(10);
                    studentInfo.setQq(qq);
                    String email =resultSet.getString(11);
                    studentInfo.setEmail(email);
                    String name2 =resultSet.getString(12);
                    studentInfo.setName2(name2);
                    String tel2 =resultSet.getString(13);
                    studentInfo.setTel2(tel2);
                }

                // 将Java对象转换为JSON格式
                String s = JSON.toJSONString(studentInfo);
                resp.getWriter().print(s);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            resp.getWriter().println("输入内容为空！");
        }
    }
}
