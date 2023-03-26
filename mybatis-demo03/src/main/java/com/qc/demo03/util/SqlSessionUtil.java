package com.qc.demo03.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @Author：钱程
 * @Date：2023/3/25/22:11
 */

public class SqlSessionUtil {

    public static SqlSession getSqlSession() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

            return sqlSessionFactory.openSession(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
