package com.qc.demo02.mapper;

import com.qc.demo02.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * User表Mapper接口
 *
 * @Author：钱程
 * @Date：2023/3/18/17:27
 */
public interface UserMapper {

    /**
     * 查询所有用户信息
     *
     * @return 所有用户信息
     */
    List<User> getAllUser();

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    User getUserByUsername(String username);

    /**
     * 验证登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户信息
     */
    User checkLogin(String username, String password);

    /**
     * 验证登录
     *
     * @param paramMap 验证参数
     * @return 用户信息
     */
    User checkLoginByMap(Map<String, Object> paramMap);

    /**
     * 添加用户信息
     *
     * @param user 用户信息
     * @return 是否添加成功
     */
    int insertUser(User user);

    /**
     * 验证登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户信息
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);

    /**
     * 根据条件查询用户信息
     *
     * @param username 用户名
     * @param paramMap 相关查询条件
     * @return 用户信息
     */
    User getUserByCondition(String username, @Param("paramMap") Map<String, Object> paramMap);
}
