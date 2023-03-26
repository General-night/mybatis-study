package com.qc.demo03.mapper;

import com.qc.demo03.entity.Dept;
import com.qc.demo03.entity.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * mybatis缓存
 *
 * @Author：钱程
 * @Date：2023/3/25/21:53
 */
public interface CacheMapper {

    Emp getEmpByEid(@Param("eid") Integer eid);

    int insertEmp(Emp emp);

    int insertDept(Dept dept);
}
