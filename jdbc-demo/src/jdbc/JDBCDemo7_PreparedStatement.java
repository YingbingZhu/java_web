package jdbc;

import org.junit.Test;

import java.sql.*;

/**
 * JDBC API statement demo
 */

public class JDBCDemo7_PreparedStatement {

    /**
     * login test
     * @throws Exception
     */
    @Test
    public void testPreparedStatement() throws Exception {
        String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false";
        String username = "root";
        String password = "19960502";
        Connection conn = DriverManager.getConnection(url, username, password);

        // get username and password
        String name = "zhu";
        String pwd = "' or '1' = '1";

        // sql
        String sql = "select * from tb_user where username = ? and password = ?";

        // pstatement
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, name);
        pstmt.setString(2, pwd);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }


        // release
        rs.close();
        pstmt.close();
        conn.close();

    }

    
}
