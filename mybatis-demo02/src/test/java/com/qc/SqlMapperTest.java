package com.qc;

import com.qc.demo02.entity.User;
import com.qc.demo02.mapper.SqlMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author：钱程
 * @Date：2023/3/22/23:33
 */
public class SqlMapperTest {

    private SqlSession sqlSession;

    @Before
    public void initSqlSession() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        sqlSession = sqlSessionFactory.openSession(true);
    }

    @Test
    public void testGetUserByNameLike() {
        SqlMapper sqlSessionMapper = sqlSession.getMapper(SqlMapper.class);
        List<User> userList = sqlSessionMapper.getUserByNameLike("jac");
        userList.forEach(System.out::println);
    }
}
