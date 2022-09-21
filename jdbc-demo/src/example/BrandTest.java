package example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;
import pojo.Brand;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * brand
 */
public class BrandTest {

    /**
     * select * from tb_brand
     */
    @Test
    public void testSelectAll() throws Exception {

        Properties prop = new Properties();
        System.out.println(System.getProperty("user.dir"));

        prop.load(new FileInputStream("src/druid.properties"));

        // 4. get druid object
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        // 5. get connection
        Connection conn = dataSource.getConnection();

        String sql = "select * from tb_brand";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        ResultSet rs = pstmt.executeQuery();

        Brand brand = null;
        List<Brand> brands = new ArrayList<>();

        while (rs.next()) {
            int id = rs.getInt("id");
            String brandName = rs.getString("brand_name");
            String companyName = rs.getString("company_name");
            String description = rs.getString("description");
            int ordered = rs.getInt("ordered");
            int status = rs.getInt("status");
            brand = new Brand();
            brand.setBrandName(brandName);
            brand.setCompanyName(companyName);
            brand.setId(id);
            brand.setOrdered(ordered);
            brand.setDescription(description);
            brand.setStatus(status);

            brands.add(brand);
        }

        rs.close();
        pstmt.close();
        conn.close();
    }

    /**
     * insert into tb_brand(brand_name, company_name, order, description, status) values (?,?,?,?,?)
     */
    @Test
    public void testInsert() throws Exception {
        // get params from page
        String brandName = "one";
        String companyName = "one company";
        int ordered = 1;
        String description = "hh";
        int status = 1;


        Properties prop = new Properties();
        System.out.println(System.getProperty("user.dir"));

        prop.load(new FileInputStream("src/druid.properties"));

        // 4. get druid object
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        // 5. get connection
        Connection conn = dataSource.getConnection();

        String sql = "insert into tb_brand(brand_name, company_name, ordered, description, status) values(?,?,?,?,?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, brandName);
        pstmt.setString(2, companyName);
        pstmt.setInt(3, ordered);
        pstmt.setString(4, description);
        pstmt.setInt(5, status);

        int count = pstmt.executeUpdate();

        System.out.println(count > 0);

        pstmt.close();
        conn.close();
    }

    /**
     * update tb_brand set brand_name = ?, company_name= ?, ordered= ?, description= ?, status= ? where id=?
     */
    @Test
    public void testUpdate() throws Exception {
        // get params from page
        String brandName = "one";
        String companyName = "one company";
        int ordered = 100;
        String description = "hhh";
        int status = 1;
        int id = 1;


        Properties prop = new Properties();
        System.out.println(System.getProperty("user.dir"));

        prop.load(new FileInputStream("src/druid.properties"));

        // 4. get druid object
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        // 5. get connection
        Connection conn = dataSource.getConnection();

        String sql = "update tb_brand set brand_name = ?, company_name= ?, ordered= ?, description= ?, status= ? where id=?";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, brandName);
        pstmt.setString(2, companyName);
        pstmt.setInt(3, ordered);
        pstmt.setString(4, description);
        pstmt.setInt(5, status);
        pstmt.setInt(6, id);

        int count = pstmt.executeUpdate();

        System.out.println(count > 0);

        pstmt.close();
        conn.close();
    }

    /**
     * delete from tb_brand  where id=?
     */
    @Test
    public void testDelete() throws Exception {
        int id = 1;


        Properties prop = new Properties();
        System.out.println(System.getProperty("user.dir"));

        prop.load(new FileInputStream("src/druid.properties"));

        // 4. get druid object
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        // 5. get connection
        Connection conn = dataSource.getConnection();

        String sql = "delete from tb_brand  where id=?";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, id);

        int count = pstmt.executeUpdate();

        System.out.println(count > 0);

        pstmt.close();
        conn.close();
    }

}
