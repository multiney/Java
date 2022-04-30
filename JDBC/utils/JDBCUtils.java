package utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 *  JDBC工具类
 */
public class JDBCUtils {

    private static String url;
    private static String user;
    private static String password;
    private static String driver;


    /**
     * 文件的读取，只需要读取一次即可拿到这些值，使用静态代码块。
     */
    static {
        //读取资源文件，获取值

        //创建Properties集合类
        Properties pro = new Properties();
        try {
            //获取JDBC路径下的文件的方式-->ClassLoader 类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL resource = classLoader.getResource("jdbc.properties");
            String path = resource.getPath();
            //加载文件
            pro.load(new FileReader(path));
            //获取数据并赋值
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            //注册驱动
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 获取连接
     * @return
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 释放资源
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt, Connection conn) {
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
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
