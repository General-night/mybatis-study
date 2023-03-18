package com.qc.mapper;

import com.qc.entity.User;

import java.util.List;

/**
 * User表Mapper接口
 *
 * @Author：钱程
 * @Date：2023/3/18/17:27
 */
public interface UserMapper {
    /*
      Mybatis 面向接口编程的两个一致：
        1、映射文件的namespace要和mapper接口的全类名保持一致
        2、映射文件中SQL语句的id要和mapper接口中的方法名一致
     */

    /**
     * 添加用户
     *
     * @return 是否添加成功
     */
    int insertUser();

    /**
     * 修改用户
     *
     * @return 是否修改成功
     */
    int update();

    /**
     * 删除用户
     *
     * @return 是否删除成功
     */
    int delete();

    /**
     * 根据id查询用户信息
     *
     * @return 用户信息
     */
    User getUserById();

    /**
     * 查询所有用户信息
     *
     * @return 所有用户信息
     */
    List<User> getAllUser();
}
