package jdbc;

import org.junit.Test;
import pojo.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC API statement demo
 */

public class JDBCDemo5_ResultSet {

    /**
     * DQL test
     * @throws Exception
     */
    @Test
    public void testResultSet() throws Exception {
        String url = "jdbc:mysql://127.0.0.1:3306/tmp?useSSL=false";
        String username = "root";
        String password = "19960502";
        Connection conn = DriverManager.getConnection(url, username, password);

        // sql
        String sql = "select * from teacher";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        // move row
        while (rs.next()) {
            // get data
            int id = rs.getInt(1);
            String name = rs.getString(2);

            System.out.println(id);
            System.out.println(name);

            System.out.println("--------------");
        }

        // release
        rs.close();
        stmt.close();
        conn.close();

    }

    /**
     * query result and save to array list
     * 1. define entity class
     * 2. query data, encapsulate
     * 3. save to array list
     * @throws Exception
     */
    @Test
    public void testResultSet2() throws Exception {
        String url = "jdbc:mysql://127.0.0.1:3306/tmp?useSSL=false";
        String username = "root";
        String password = "19960502";
        Connection conn = DriverManager.getConnection(url, username, password);

        // sql
        String sql = "select * from teacher";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        List<Account> list = new ArrayList<>();

        // move row
        while (rs.next()) {
            Account account = new Account();

            // get data
            int id = rs.getInt(1);
            String name = rs.getString(2);

            account.setId(id);
            account.setName(name);

            list.add(account);
        }

        System.out.println(list);

        // release
        rs.close();
        stmt.close();
        conn.close();

    }

    
}
