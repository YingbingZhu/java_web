package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC demo
 */

public class JDBCDemo3_Connection {
    // throws:may occur error
    public static void main(String[] args) throws Exception {
        // 1. register driver, load to memory
//        Class.forName("com.mysql.jdbc.Driver");

        // 2. get connection ( url, username, password
        String url = "jdbc:mysql://127.0.0.1:3306/tmp?useSSL=false";
        String username = "root";
        String password = "19960502";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3. sql
        String sql1 = "update teacher set name = 'zhu' where id = 1";
        String sql2 = "update teacher set name = 'zhu' where id = 2";

        // 4. get sql executor statement
        Statement stmt = conn.createStatement();



        try {
            // OPEN TRANSACTION
            conn.setAutoCommit(false);
            // 5. execute sql
            int count1 = stmt.executeUpdate(sql1);

            System.out.println(count1);

            int count2 = stmt.executeUpdate(sql2);

            System.out.println(count2);
            // COMMIT TRANSACTION
            conn.commit();
        } catch (Exception throwables) {
            // rollback
            conn.rollback();
            throwables.printStackTrace();
        }



        // 7. release
        stmt.close();
        conn.close();
    }
}
