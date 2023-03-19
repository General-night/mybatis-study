package com.qc.demo02.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户表
 *
 * @Author：钱程
 * @Date：2023/3/18/17:21
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    public void setUsername1(String username1) {

    }

    public String getUsername1() {
        
        return "username1";
    }
}
