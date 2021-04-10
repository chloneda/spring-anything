package com.chloneda.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class SqlSessionFactoryUtils {
    private static final Class<SqlSessionFactoryUtils> LOCK = SqlSessionFactoryUtils.class;

    private static SqlSessionFactory sqlSessionFactory = null;
    private static final String resource = "mybatis-config.xml";

    private SqlSessionFactoryUtils() {
    }

    /**
     * 使用配置文件方式配置MyBatis
     *
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        synchronized (LOCK) {
            if (null != sqlSessionFactory) {
                return sqlSessionFactory;
            }

            try {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

            return sqlSessionFactory;
        }
    }

    public static SqlSession getSqlSession() {
        if (null == sqlSessionFactory) {
            getSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }


    /**
     * 使用Java API 配置MyBatis
     */
    public static SqlSessionFactory getSqlSessionFactoryInstance() {
        return sqlSessionFactory;
    }

}
