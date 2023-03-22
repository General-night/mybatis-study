package com.qc.demo02.mapper;

import com.qc.demo02.entity.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author：钱程
 * @Date：2023/3/22/0:23
 */
public interface SelectMapper {

    /**
     * 根据id获取用户信息
     *
     * @param id 用户id
     * @return 用户信息
     */
    User getUserById(@Param("id") Integer id);

    /**
     * 查询所有用户信息
     *
     * @return 所有用户信息
     */
    List<User> getAllUser();

    /**
     * 查询总记录数
     *
     * @return 总记录数
     */
    Integer getTotal();

    /**
     * 查询所有用户信息，并转为Map集合
     *
     * @return 用户信息
     */
    @MapKey("id")
    Map<String, Object> getAllUserToMap();
}
