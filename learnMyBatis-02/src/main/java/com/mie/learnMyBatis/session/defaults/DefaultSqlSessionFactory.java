package com.mie.learnMyBatis.session.defaults;

import com.mie.learnMyBatis.binding.MapperRegistry;
import com.mie.learnMyBatis.session.SqlSession;
import com.mie.learnMyBatis.session.SqlSessionFactory;

/**
 * @author: xYLiu
 * @description
 * @date: 2024/4/29 15:48
 */

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }

}
