package com.mie.learnMyBatis.session;

import com.mie.learnMyBatis.builder.xml.XMLConfigBuilder;
import com.mie.learnMyBatis.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;
/**
 * @author 3A87
 * @description 构建SqlSessionFactory的工厂
 * @date 2024/4/22
 */
public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(Reader reader){
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config){
        return new DefaultSqlSessionFactory(config);
    }
}
