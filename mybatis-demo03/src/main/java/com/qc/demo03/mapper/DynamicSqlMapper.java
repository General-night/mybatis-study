package com.qc.demo03.mapper;

import com.qc.demo03.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 动态SQL
 *
 * @Author：钱程
 * @Date：2023/3/25/17:35
 */
public interface DynamicSqlMapper {

    /**
     * 多条件查询
     *
     * @param condition 条件
     * @return 员工信息
     */
    List<Emp> getEmpByCondition(Emp condition);

    /**
     * 根据条件查询员工信息<br/>
     * 测试：chooses、when、otherwise
     *
     * @param condition 查询条件
     * @return 员工信息
     */
    List<Emp> getEmpByChoose(Emp condition);

    /**
     * 通过数组传参，进行员工批量删除
     *
     * @param eidArr 删除员工的id
     * @return 删除个数
     */
    int deleteMoreByArray(@Param("eidArr") Integer[] eidArr);

    /**
     * 批量添加员工信息
     *
     * @param empList 员工信息集合
     * @return 添加条数
     */
    int insertMoreByList(@Param("empList") List<Emp> empList);
}
