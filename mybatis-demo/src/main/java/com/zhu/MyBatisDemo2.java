package com.zhu;

import com.zhu.mapper.UserMapper;
import com.zhu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * my batis agent development
 */
public class MyBatisDemo2 {
    public static void main(String[] args) throws Exception {
        // 1. load mybatis core config, get SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. Use sqlSession to execute sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. execute sql
        // List<Object> users = sqlSession.selectList("test.selectAll");
        // get agent object
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();
        System.out.println(users);

        sqlSession.close();

        
    }
}
