package com.qc;

import com.qc.demo03.entity.Dept;
import com.qc.demo03.entity.Emp;
import com.qc.demo03.mapper.CacheMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author：钱程
 * @Date：2023/3/25/21:55
 */
public class CacheMapperTest {
    private SqlSession sqlSession;

    @Before
    public void initSqlSession() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        sqlSession = sqlSessionFactory.openSession(true);
    }

    @Test
    public void testCache() {
        CacheMapper cacheMapper1 = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = cacheMapper1.getEmpByEid(1);
        System.out.println("emp1 = " + emp1);
        CacheMapper cacheMapper2 = sqlSession.getMapper(CacheMapper.class);
        Emp emp2 = cacheMapper2.getEmpByEid(1);
        System.out.println("emp2 = " + emp2);
    }

    /**
     * 同一个sqlSession两次查询期间执行了任何一次增删改操作都会清空一级缓存
     */
    @Test
    public void testCache_2() {
        CacheMapper cacheMapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp_1 = cacheMapper.getEmpByEid(1);
        System.out.println("emp_1 = " + emp_1);

        int i = cacheMapper.insertDept(Dept.builder().deptName("D").build());
        System.out.println("i = " + i);

        //sqlSession.clearCache();

        Emp emp_2 = cacheMapper.getEmpByEid(1);
        System.out.println("emp_2 = " + emp_2);
    }

    @Test
    public void testCache_3() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
            CacheMapper cacheMapper1 = sqlSession1.getMapper(CacheMapper.class);
            Emp emp1 = cacheMapper1.getEmpByEid(1);
            System.out.println("emp1 = " + emp1);
            //sqlSession1.clearCache();
            sqlSession1.commit(true);
            SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
            CacheMapper cacheMapper2 = sqlSession2.getMapper(CacheMapper.class);
            Emp emp2 = cacheMapper2.getEmpByEid(1);
            System.out.println("emp2 = " + emp2);
            sqlSession2.commit(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
