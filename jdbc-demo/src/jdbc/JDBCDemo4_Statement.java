package jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC API statement demo
 */

public class JDBCDemo4_Statement {

    /**
     * DML test
     * @throws Exception
     */
    @Test
    public void testDML() throws Exception {
        String url = "jdbc:mysql://127.0.0.1:3306/tmp?useSSL=false";
        String username = "root";
        String password = "XXX";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3. sql
        String sql = "update teacher set name = 'zhu' where id = 5";

        // 4. get sql executor statement
        Statement stmt = conn.createStatement();
        // 5. execute sql
        int count = stmt.executeUpdate(sql);

        if (count > 0) {
            System.out.println("success");
        } else {
            System.out.println("failed");
        }

        // 7. release
        stmt.close();
        conn.close();

    }

    /**
     * DDL test
     * @throws Exception
     */
    @Test
    public void testDDL() throws Exception {
        String url = "jdbc:mysql://127.0.0.1:3306/tmp?useSSL=false";
        String username = "root";
        String password = "19960502";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3. sql
        String sql = "create database db1";

        // 4. get sql executor statement
        Statement stmt = conn.createStatement();
        // 5. execute sql
        int count = stmt.executeUpdate(sql); // if DDL maybe 0, use try catch

//        if (count > 0) {
//            System.out.println("success");
//        } else {
//            System.out.println("failed");
//        }

        // 7. release
        stmt.close();
        conn.close();

    }
    
}
