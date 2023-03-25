package com.qc.demo03.mapper;

import com.qc.demo03.entity.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @Author：钱程
 * @Date：2023/3/24/0:12
 */
public interface DeptMapper {

    Dept getEmpAndDeptByStepTow(@Param("did") Integer did);

    Dept getDeptAndEmpByDid(@Param("did") Integer did);

    Dept getDeptAndEmpByStep(@Param("did") Integer did);
}
