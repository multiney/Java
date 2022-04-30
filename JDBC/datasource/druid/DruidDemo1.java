package datasource.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class DruidDemo1 {


    public static void main(String[] args) throws Exception {
        //导入jar包
        //定义配置文件
        //加载配置文件
        Properties pro = new Properties();
        InputStream is = DruidDemo1.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        //获取连接池对象
        DataSource ds= DruidDataSourceFactory.createDataSource(pro);
        //获取连接

    }


}
