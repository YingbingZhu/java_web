package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC API DriverManager
 */

public class JDBCDemo2_DriverManager {
    // throws:may occur error
    public static void main(String[] args) throws Exception {
        // 1. register driver, load to memory
//        Class.forName("com.mysql.jdbc.Driver");

        // 2. get connection ( url, username, password
        String url = "jdbc:mysql:///tmp?useSSL=false";
        String username = "root";
        String password = "19960502";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3. sql
        String sql = "update teacher set name = 'zhu' where id = 1";

        // 4. get sql executor statement
        Statement stmt = conn.createStatement();

        // 5. execute sql
        // affected rows
        int count = stmt.executeUpdate(sql);

        System.out.println(count);

        // 7. release
        stmt.close();
        conn.close();
    }
}
