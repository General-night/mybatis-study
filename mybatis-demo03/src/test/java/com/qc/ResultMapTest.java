package com.qc;

import com.qc.demo03.entity.Dept;
import com.qc.demo03.entity.Emp;
import com.qc.demo03.mapper.DeptMapper;
import com.qc.demo03.mapper.EmpMapper;
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
 * @Date：2023/3/25/12:50
 */
public class ResultMapTest {
    private SqlSession sqlSession;

    @Before
    public void initSqlSession() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        sqlSession = sqlSessionFactory.openSession(true);
    }

    @Test
    public void testGetAllEmp() {
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> empList = empMapper.getAllEmp();
        empList.forEach(System.out::println);
    }

    @Test
    public void testGetEmpAndDeptByEid() {
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = empMapper.getEmpAndDeptByEid(1);
        System.out.println("emp = " + emp);
    }

    @Test
    public void testGetEmpAndDeptByStep() {
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = empMapper.getEmpAndDeptByStep(4);
        System.out.println("emp.empName = " + emp.getEmpName());
        System.out.println("---------------------------------");
        System.out.println("emp.dept = " + emp.getDept());
    }

    @Test
    public void testGetDeptAndEmpByDid() {
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = deptMapper.getDeptAndEmpByDid(1);
        System.out.println("dept = " + dept);
    }

    @Test
    public void testGetDeptAndEmpByStep() {
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = deptMapper.getDeptAndEmpByStep(1);
        System.out.println("dept.deptName = " + dept.getDeptName());
        System.out.println("---------------------------------");
        System.out.println("dept = " + dept);
    }
}
