package com.mie.learnMyBatis.session.defaults;

import com.mie.learnMyBatis.session.Configuration;
import com.mie.learnMyBatis.session.SqlSession;
import com.mie.learnMyBatis.session.SqlSessionFactory;

/**
 * @author: xYLiu
 * @description
 * @date: 2024/4/29 15:48
 */

public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
