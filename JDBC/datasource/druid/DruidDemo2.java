package datasource.druid;

import utils.JDBCUtils2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用工具类
 */
public class DruidDemo2 {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            //获取连接
            conn = JDBCUtils2.getConnection();
            //定义sql
            String sql = "insert account values(?, ?)";
            //获取操作sql的对象
            pstmt = conn.prepareStatement(sql);
            //给sql语句参数赋值
            pstmt.setInt(1, 1);
            pstmt.setInt(2,100);
            //操作sql
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils2.close(pstmt, conn);
        }
    }
}
