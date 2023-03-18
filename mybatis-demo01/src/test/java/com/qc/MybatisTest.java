package com.qc;

import com.qc.entity.User;
import com.qc.mapper.UserMapper;
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
 * Mybatis测试类
 *
 * @Author：钱程
 * @Date：2023/3/18/18:05
 */

public class MybatisTest {

    private SqlSession sqlSession;

    @Before
    public void initSqlSession() throws IOException {
        // 加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 获取 SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        // 获取 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        // 获取 SqlSession
        /*
            SqlSession 默认不自动提交事务，可以设置参数改为自动提交
         */
        sqlSession = sqlSessionFactory.openSession(true);
    }

    @Test
    public void testInsert() {

        // 获取mapper接口对象，底层使用的是代理模式
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 测试功能
        int i = userMapper.insertUser();
        System.out.println("i = " + (i > 0 ? "添加成功" : "添加失败"));

        // 提交事务
        //sqlSession.commit();
    }

    @Test
    public void testUpdate() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.update());
    }

    @Test
    public void testDelete() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.delete());
    }

    @Test
    public void testSelectSingle() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById();
        System.out.println("user = " + user);
    }

    @Test
    public void testSelectAllUser() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getAllUser();
        userList.forEach(System.out::println);
    }
}
