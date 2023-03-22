package com.qc;

import com.qc.demo02.entity.User;
import com.qc.demo02.mapper.SelectMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @Author：钱程
 * @Date：2023/3/22/0:26
 */

public class SelectMapperTest {

    private SqlSession sqlSession;

    @Before
    public void initSqlSession() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        sqlSession = sqlSessionFactory.openSession(true);
    }

    @Test
    public void testGetUserById() {
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        User user = selectMapper.getUserById(3);
        System.out.println("user = " + user);
    }

    @Test
    public void testGetAllUser() {
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        List<User> userList = selectMapper.getAllUser();
        userList.forEach(System.out::println);
    }

    @Test
    public void testGetTotal() {
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        Integer total = selectMapper.getTotal();
        System.out.println("total = " + total);
    }

    @Test
    public void testGetAllUserToMap() {
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> resultMap = selectMapper.getAllUserToMap();
        System.out.println("resultMap = " + resultMap);
    }
}
