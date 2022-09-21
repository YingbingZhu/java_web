package druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Druid
 */
public class DruidDemo {

    public static void main(String[] args) throws Exception{
        // 1. import jar

        // 2. define config

        // 3. load config
        Properties prop = new Properties();
        System.out.println(System.getProperty("user.dir"));
        
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));

        // 4. get druid object
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        // 5. get connection
        Connection connection = dataSource.getConnection();

        System.out.println(connection);

        //
    }
}
