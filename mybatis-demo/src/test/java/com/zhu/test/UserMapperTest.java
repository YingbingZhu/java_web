package com.zhu.test;

import com.zhu.mapper.BrandMapper;
import com.zhu.mapper.UserMapper;
import com.zhu.pojo.Brand;
import com.zhu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class UserMapperTest {

    @Test
    public void testSelect() throws Exception {
        String userName = "wei";
        String password = "wei";

        // 1. get sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.select(userName, password);

        System.out.println(user);

        sqlSession.close();
    }




}
