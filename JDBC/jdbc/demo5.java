package jdbc;

import domain.Student;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class demo5 {

    public static void main(String[] args) {
        demo5 demo5 = new demo5();

        List<Student> sList = demo5.findAll2();
        System.out.println(sList);

    }

    public List<Student> findAll2() {

        List<Student> result = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet res = null;
        try {
            //获取连接
            conn = JDBCUtils.getConnection();
            //获取操作SQL的对象
            stmt = conn.createStatement();
            //构造SQL语句
            String sql = "select * from student;";
            //操作Sql，返回结果
            res = stmt.executeQuery(sql);
            //初始化表
            result = new ArrayList<>();
            //处理结果
            while (res.next()) {
                //获取数据并赋值
                int id = res.getInt("id");
                String name = res.getString("name");
                double score = res.getDouble("score");
                int age_id = res.getInt("age_id");


                //创建Student对象
                Student s = new Student();
                s.setId(id);
                s.setName(name);
                s.setScore(score);
                s.setAge_id(age_id);
                //添加对象至集合
                result.add(s);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(res, stmt, conn);
        }
        return result;
    }
}
