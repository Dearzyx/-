package pojo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class pojo {

        private static String url;
        private static String username;
        private static String password;
        private static String Driver;
        //使用配置文件
        //文件的读取只需要读取一次即可拿到这些值。使用静态代码块
        static {
            //读取资源文件，获取值
            //1.创建properties集合类
            Properties pro = new Properties();

            try {
                //2.加载文件
                pro.load(new FileReader("D:\\毕业设计\\biyesheji\\src\\jdbc.properties"));
                //3.获取数据，赋值
                url = pro.getProperty("url");
                username = pro.getProperty("username");
                password = pro.getProperty("password");
                Driver = pro.getProperty("driver");
                //注册驱动
                try {
                    Class.forName(Driver);
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        public static Connection getConnection() throws Exception {
            //1获取连接

            return DriverManager.getConnection(url,username,password);

        }
        //释放资源
        public static void close(Statement stmt, Connection conn) {
            if(stmt!=null) {
                try {
                    stmt.close();

                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        public static void close(ResultSet rs, Statement stmt, Connection conn) {
            if(rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(stmt!=null) {
                try {
                    stmt.close();

                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

