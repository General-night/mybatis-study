package com.qc.demo03.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
public class Emp implements Serializable {

    private static final long serialVersionUID = 2023032614;

    private Integer eid;

    private String empName;

    private Integer age;

    private String sex;

    private String email;

    private Integer did;

    private Dept dept;
}
