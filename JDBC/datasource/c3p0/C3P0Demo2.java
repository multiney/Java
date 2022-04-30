package datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Demo2 {

    public static void main(String[] args) throws SQLException {
        //获取DataSource
        DataSource ds = new ComboPooledDataSource();
        //获取连接
        for (int i = 1; i <= 11; ++i) {
            Connection conn = ds.getConnection();
            System.out.println(i + ": " + conn);

            if (i == 6) {
                conn.close();//归还连接
            }
        }
    }
}
