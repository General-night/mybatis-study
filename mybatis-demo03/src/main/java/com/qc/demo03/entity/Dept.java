package com.qc.demo03.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 部门表
 *
 * @Author：钱程
 * @Date：2023/3/24/0:11
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dept {

    private Integer did;

    private String deptName;

    private List<Emp> empList;
}
