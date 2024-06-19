package com.mie.learnMyBatis.session;


import com.mie.learnMyBatis.binding.MapperRegistry;
import com.mie.learnMyBatis.datasource.druid.DruidDataSourceFactory;
import com.mie.learnMyBatis.mapping.Environment;
import com.mie.learnMyBatis.mapping.MappedStatement;
import com.mie.learnMyBatis.transaction.jdbc.JdbcTransactionFactory;
import com.mie.learnMyBatis.type.TypeAliasRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xYLiu
 * @description 配置项
 * @date: 2024/4/29 15:38
 */

public class Configuration {
    //环境
    protected Environment environment;

    //映射注册机
    protected MapperRegistry mapperRegistry = new MapperRegistry(this);

    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();

    //类型别名注册机
    protected final TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();

    public Configuration() {
        typeAliasRegistry.registerAlias("JDBC", JdbcTransactionFactory.class);
        typeAliasRegistry.registerAlias("DRUID", DruidDataSourceFactory.class);
    }

    public void addMappers(String packageName) {
        mapperRegistry.addMappers(packageName);
    }
    public <T> void addMapper(Class<T> type){
        mapperRegistry.addMapper(type);
    }
    public <T> T getMapper(Class<T> type,SqlSession sqlSession){
        return mapperRegistry.getMapper(type,sqlSession);
    }
    public boolean hasMapper(Class<?> type){
        return mapperRegistry.hasMapper(type);
    }
    public void addMappedStatement(MappedStatement ms){
        mappedStatements.put(ms.getId(),ms);
    }
    public MappedStatement getMappedStatement(String id){
        return mappedStatements.get(id);
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public MapperRegistry getMapperRegistry() {
        return mapperRegistry;
    }

    public void setMapperRegistry(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    public Map<String, MappedStatement> getMappedStatements() {
        return mappedStatements;
    }

    public TypeAliasRegistry getTypeAliasRegistry() {
        return typeAliasRegistry;
    }
}
