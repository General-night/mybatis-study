package com.qc.demo03.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 员工表
 *
 * @Author：钱程
 * @Date：2023/3/24/0:10
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Emp {

    private Integer eid;

    private String empName;

    private Integer age;

    private String sex;

    private String email;

    private Dept dept;
}
