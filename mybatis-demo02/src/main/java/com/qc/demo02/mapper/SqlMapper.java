package com.qc.demo02.mapper;

import com.qc.demo02.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author：钱程
 * @Date：2023/3/22/23:29
 */
public interface SqlMapper {

    /**
     * 根据用户名模糊查询用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    List<User> getUserByNameLike(@Param("username") String username);

    /**
     * 批量删除
     *
     * @param ids id
     * @return 是否删除成功
     */
    int batchDelete(@Param("ids") String ids);

    /**
     * 根据表名查询用户信息
     *
     * @param tableName 表名
     * @return 用户信息
     */
    List<User> getUserByTableName(@Param("tableName") String tableName);

    /**
     * 添加用户
     *
     * @param user 用户信息
     */
    void insertUser(User user);
}
