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

public class JDBCDemo6_UserLogin {

    /**
     * login test
     * @throws Exception
     */
    @Test
    public void testLogin() throws Exception {
        String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false";
        String username = "root";
        String password = "19960502";
        Connection conn = DriverManager.getConnection(url, username, password);

        // get username and password
        String name = "zhu";
        String pwd = "123";

        // sql
        String sql = "select * from tb_user where username = '"+name+"' and password = '"+pwd+"'";

        // statement
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        if (rs.next()) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }


        // release
        rs.close();
        stmt.close();
        conn.close();

    }

    /**
     * sql inject
     * @throws Exception
     */
    @Test
    public void testLogin_Inject() throws Exception {
        String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false";
        String username = "root";
        String password = "19960502";
        Connection conn = DriverManager.getConnection(url, username, password);

        // get username and password
        String name = "dsfsf";
        String pwd = "' or '1' = '1";

        // sql
        String sql = "select * from tb_user where username = '"+name+"' and password = '"+pwd+"'";

        // statement
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        if (rs.next()) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }


        // release
        rs.close();
        stmt.close();
        conn.close();

    }

    
}
