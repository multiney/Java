package jdbc;

import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class demo7 {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;

        try {
            //获取数据库连接
            conn = JDBCUtils.getConnection();
            //开启事务
            conn.setAutoCommit(false);
            //构造sql语句
            String sql1 = "update isolation_test set amount = amount - ? where id = ?";
            String sql2 = "update isolation_test set amount = amount + ? where id = ?";
            //获取操作sql的对象
            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
            //给sql语句中?赋值
            pstmt1.setInt(1, 500);
            pstmt1.setInt(2, 1);
            pstmt2.setInt(1, 500);
            pstmt2.setInt(2, 2);
            //执行sql语句
            pstmt1.executeUpdate();
            int a = 3 / 0;
            pstmt2.executeUpdate();
        } catch (Exception e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(pstmt1, conn);
            JDBCUtils.close(pstmt2, null);
        }
    }
}
