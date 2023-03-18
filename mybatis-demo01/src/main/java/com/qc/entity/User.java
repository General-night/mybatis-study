package com.qc.entity;

import lombok.Data;

/**
 * 用户表
 *
 * @Author：钱程
 * @Date：2023/3/18/17:21
 */

@Data
public class User {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private Character sex;

    /**
     * 邮箱
     */
    private String email;
}
