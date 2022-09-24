package com.zhu.test;

import com.zhu.mapper.BrandMapper;
import com.zhu.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class MyBatisTest {

    @Test
    public void testSelectAll() throws Exception {
        // 1. get sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.selectAll();

        System.out.println(brands);

        sqlSession.close();
    }

    @Test
    public void testSelectById() throws Exception {
        //
        int id = 1;
        // 1. get sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = brandMapper.selectById(id);

        System.out.println(brand);

        sqlSession.close();
    }

    @Test
    public void testSelectByCondition() throws Exception {
        //
        int status = 1;
        String companyName = "wei";
        String brandName = "wei";

        // process params
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setStatus(status);
//
//        Map map = new HashMap<>();
//        map.put("status", status);


        // 1. get sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.selectByCondition(brand);

        System.out.println(brand);

        sqlSession.close();
    }

    @Test
    public void testSelectByConditionSingle() throws Exception {
        //
        int status = 1;
        String companyName = "wei";
        String brandName = "wei";

        // process params
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        Brand brand = new Brand();
//        brand.setBrandName(brandName);
//        brand.setCompanyName(companyName);
        brand.setStatus(status);



        // 1. get sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.selectByConditionSingle(brand);

        System.out.println(brands);

        sqlSession.close();
    }

    @Test
    public void testAdd() throws Exception {
        //
        int status = 1;
        String companyName = "wei1";
        String brandName = "wei1";
        String description = "wei1";
        int ordered = 100;


        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setStatus(status);
        brand.setDescription(description);
        brand.setOrdered(ordered);



        // 1. get sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.add(brand);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testAdd2() throws Exception {
        //
        int status = 1;
        String companyName = "wei1";
        String brandName = "wei1";
        String description = "wei1";
        int ordered = 100;


        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setStatus(status);
        brand.setDescription(description);
        brand.setOrdered(ordered);



        // 1. get sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.add(brand);
        System.out.println(brand.getId());

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testUpdate() throws Exception {
        //
        int status = 1;
        String companyName = "wei2";
        String brandName = "wei2";
        String description = "wei1";
        int ordered = 100;
        int id = 6;


        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setStatus(status);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setId(id);



        // 1. get sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        int count = brandMapper.update(brand);
        System.out.println(count);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testDeleteById() throws Exception {

        int id = 6;


        // 1. get sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.deleteById(id);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testDeleteByIds() throws Exception {

        int[] ids = {7, 8};


        // 1. get sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.deleteByIds(ids);

        sqlSession.commit();

        sqlSession.close();
    }
}
