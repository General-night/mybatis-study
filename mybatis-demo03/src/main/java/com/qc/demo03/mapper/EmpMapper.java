package com.qc.demo03.mapper;

import com.qc.demo03.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author：钱程
 * @Date：2023/3/24/0:12
 */
public interface EmpMapper {

    List<Emp> getAllEmp();

    Emp getEmpAndDeptByEid(@Param("eid") Integer eid);

    Emp getEmpAndDeptByStep(@Param("eid") Integer eid);

    List<Emp> getEmpByDid(@Param("did") Integer did);
}
