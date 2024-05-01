package com.mie.learnMyBatis.session.defaults;

import com.mie.learnMyBatis.mapping.MappedStatement;
import com.mie.learnMyBatis.session.Configuration;
import com.mie.learnMyBatis.session.SqlSession;

/**
 * @author: xYLiu
 * @description
 * @date: 2024/4/29 15:48
 */

public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement mappedStatement = configuration.getMappedStatement(statement);
        return (T) ("你被代理了！" + "\n方法：" + statement + "\n入参：" + parameter + "\n待执行SQL：" + mappedStatement.getSql());
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }
}
