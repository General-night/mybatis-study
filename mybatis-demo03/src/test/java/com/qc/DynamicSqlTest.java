package com.qc;

import com.qc.demo03.entity.Emp;
import com.qc.demo03.mapper.DynamicSqlMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @Author：钱程
 * @Date：2023/3/25/17:43
 */
public class DynamicSqlTest {

    private SqlSession sqlSession;

    @Before
    public void initSqlSession() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        sqlSession = sqlSessionFactory.openSession(true);
    }

    @Test
    public void testGetEmpGyCondition() {
        DynamicSqlMapper dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);
        Emp condition = Emp.builder().empName("张三").email("123@qq.com").sex("男").build();
        List<Emp> empList = dynamicSqlMapper.getEmpByCondition(condition);
        empList.forEach(System.out::println);
    }

    @Test
    public void testGetEmpByChoose() {
        DynamicSqlMapper dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);
        Emp condition = Emp.builder().empName("李四").build();
        List<Emp> empList = dynamicSqlMapper.getEmpByChoose(condition);
        empList.forEach(System.out::println);
    }

    @Test
    public void testDeleteMoreByArray() {
        DynamicSqlMapper dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);
        int i = dynamicSqlMapper.deleteMoreByArray(new Integer[]{});
        System.out.println("i = " + i);
    }

    @Test
    public void testInsertMoreByList() {
        DynamicSqlMapper dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<Emp> empList = Arrays.asList(
                Emp.builder().empName("Alien").age(14).sex("女").email("123@qq.com").did(3).build(),
                Emp.builder().empName("Jack").age(15).sex("女").email("123@qq.com").did(2).build(),
                Emp.builder().empName("Lucy").age(18).sex("女").email("123@qq.com").did(1).build(),
                Emp.builder().empName("Boy").age(17).sex("男").email("123@qq.com").did(1).build()
        );

        int i = dynamicSqlMapper.insertMoreByList(empList);
        System.out.println("i = " + i);
    }
}
