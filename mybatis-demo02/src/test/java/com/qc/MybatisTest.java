package com.qc;

import com.qc.demo02.entity.User;
import com.qc.demo02.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        sqlSession = sqlSessionFactory.openSession(true);
    }

    /*
        Mybatis获取参数的两种方式：
            1. ${}：字符串拼接【需要注意处理SQL单引号问题】
            2. #{}：占位符赋值【能够预防SQL注入，也不用处理SQL加单引号问题】

        Mybatis获取参数值的各种情况：
            1. mapper接口方法的参数为单个字面量类型
                - 可以通过#{}或${}以任意的字符串名称获取参数值，但是需要注意${}的单引号问题
            2. mapper接口方法的参数为多个时：
     */

    @Test
    public void testSelectAllUser() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getAllUser();
        userList.forEach(System.out::println);
    }

    @Test
    public void testGetUserByUsername() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserByUsername("Jack");
        System.out.println("user = " + user);
    }

    @Test
    public void testCheckLogin() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.checkLogin("Jack", "123");
        System.out.println(Objects.nonNull(user) ? "登录成功！" : "登录失败！");
    }

    @Test
    public void testCheckLoginByMap() {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", "Jack");
        paramMap.put("password", "123");
        
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.checkLoginByMap(paramMap);
        System.out.println(Objects.nonNull(user) ? "登录成功！" : "登录失败！");
    }

    /**
     * 注意：在一个实体类中，属性和成员变量不是一个概念，属性时SETTER/GETTER方法去了set/get之后小驼峰称为属性
     */
    @Test
    public void testInsertUser() {
        User userInfo = User.builder().username("Alien").password("123").age(23).sex('女').email("123@qq.com").build();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.insertUser(userInfo);
        System.out.println(i > 0 ? "添加成功！" : "添加失败！");
    }

    @Test
    public void testCheckLoginByParam() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.checkLoginByParam("Jack", "123");
        System.out.println(Objects.nonNull(user) ? "登录成功！" : "登录失败！");
    }

    @Test
    public void testGetUserByCondition() {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("password", "123");
        paramMap.put("age", 20);

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserByCondition("Jack", paramMap);
        System.out.println("user = " + user);
    }
}
