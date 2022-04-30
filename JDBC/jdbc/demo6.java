package jdbc;

import utils.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * login
 */
public class demo6 {

    public static void main(String[] args) {
        //创建输入对象
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = sc.nextLine();
        System.out.println("Enter password:");
        String password = sc.nextLine();
        //调用方法
        boolean flag = new demo6().login2(username, password);
        if (flag) {
            System.out.println("success!");
        }
        else {
            System.out.println("failed!");
        }
    }

    public boolean login(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        //判断数据库登陆是否成功

        Connection conn = null;
        Statement stmt = null;
        ResultSet res = null;
        try {
            //获取连接
            conn = JDBCUtils.getConnection();
            //获取操作SQL的对象
            stmt = conn.createStatement();
            //构造SQL语句
            String sql = "select * from user where username = '" + username + "' && password = '" + password + "' ";
            //执行sql语句
            res = stmt.executeQuery(sql);
            //判断结果是否含有有效信息
            return res.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(res, stmt, conn);
        }
    }

    public boolean login2(String username, String password) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;
        try {
            //创建链接
            conn = JDBCUtils.getConnection();
            //构造sql语句
            String sql = "select * from user where username = ? && password = ?";
            //创建操作SQL的对象
            pstmt = conn.prepareStatement(sql);
            //给参数?赋值
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            //执行SQL语句
            res = pstmt.executeQuery();
            //判断
            return res.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(res, pstmt, conn);
        }

    }
}
