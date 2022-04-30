package jdbc;

import java.sql.*;

public class demo3 {

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet res = null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取链接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "admin");
            //构造SQL语句
            String sql = "select * from student";
            //获取执行SQL的对象
            stmt = conn.createStatement();
            //执行sql语句，获取结果信息
            res = stmt.executeQuery(sql);
            //游标下移，并判断是否有数据
            while (res.next()) {
                //获取结果数据
                int id = res.getInt(1);
                String name = res.getString(2);
                double score = res.getDouble(3);
                int age_id = res.getInt("age_id");
                //输出数据
                System.out.println(id + ": " + name + ", " + score + ", " + age_id + "\n");
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (res != null) {
                try {
                    res.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
