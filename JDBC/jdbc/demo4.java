package jdbc;

import domain.Student;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class demo4 {

    public static void main(String[] args) {
        List<Student> students = findAll();
        for (Student s : students) {
            System.out.println(s);
        }
    }
    /**
     * 查询所有student对象
     * @return
     */
    public static List<Student> findAll() {

        Connection conn = null;
        Statement stmt = null;
        ResultSet res = null;
        //创建对象的集合
        List<Student> result = new ArrayList<>();
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "admin");
            //构造sql
            String sql = "select * from student";
            //获取操作sql的对象
            stmt = conn.createStatement();
            //操作sql
            res = stmt.executeQuery(sql);

            //处理结果,并封装对象
            //游标下移，并且判断是否有数据
            while (res.next()) {
                //创建数据
                int id = res.getInt("id");
                String name = res.getString("name");
                double score = res.getDouble("score");
                int age_id = res.getInt("age_id");

                //创建student对象
                Student s = new Student();
                s.setId(id);
                s.setName(name);
                s.setScore(score);
                s.setAge_id(age_id);
                //加载对象至集合
                result.add(s);
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
        return result;
    }
}
