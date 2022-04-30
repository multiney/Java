package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Druid连接池的工具类
 */
public class JDBCUtils2 {

    //定义成员变量
    private static DataSource ds;

    static {
        //加载配置文件
        Properties pro = new Properties();
        try {
            pro.load(JDBCUtils2.class.getClassLoader().getResourceAsStream("druid.properties"));
            //获取DataSource
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 获取连接的方法
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 释放资源
     */
    public static void close(Statement stmt, Connection conn) {
//        if (stmt != null) {
//            try {
//                stmt.close();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//        if (conn != null) {
//            try {
//                conn.close();//归还连接
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
        close(null, stmt, conn);
    }


    /**
     * 释放资源
     */
    public static void close(ResultSet res, Statement stmt, Connection conn) {
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
                conn.close();//归还连接
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 获取连接池的方法
     */
    public static DataSource getDataSource() {
        return ds;
    }
}
