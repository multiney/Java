package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class demo2 {

    public static void main(String[] args) {

//        //注册驱动
//        Class.forName("com.mysql.jdbc.Driver");
//        //获取链接
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "admin");
//        //定义sql语句
//        String sql = "update student set score = 99 where id = 2";
//        //获取statement
//        Statement stmt = conn.createStatement();
//        //操作sql
//        int count = stmt.executeUpdate(sql);
//        //返回影响行数
//        System.out.println(count);
//        //释放资源
//        conn.close();
//        stmt.close();


        Connection conn = null;
        Statement stmt = null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取Connection对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "admin");
            //获取操作sql的对象，statement
            stmt = conn.createStatement();
            //构造SQL语句
            String sql = "delete from student where id = 7";
            //执行sql语句
            int count = stmt.executeUpdate(sql);
            //返回行数>1，显示操作成功
            if (count > 0) {
                System.out.println("操作成功！");
            }
            else {
                System.out.println("操作失败！");
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }
}
