package com.zhu;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * my batis demo
 */
public class MyBatisDemo {
    public static void main(String[] args) throws Exception {
        // 1. load mybatis core config, get SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. Use sqlSession to execute sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. execute sql
        List<Object> users = sqlSession.selectList("test.selectAll");
        System.out.println(users);

        sqlSession.close();

        
    }
}
