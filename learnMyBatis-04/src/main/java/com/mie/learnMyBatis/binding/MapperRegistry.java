package com.mie.learnMyBatis.binding;

import cn.hutool.core.lang.ClassScanner;
import com.mie.learnMyBatis.session.Configuration;
import com.mie.learnMyBatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: xYLiu
 * @description 映射器注册机
 * @date: 2024/4/29 15:39
 */

public class MapperRegistry {
    private Configuration config;

    public MapperRegistry(Configuration config) {
        this.config = config;
    }

    /**
     * 已添加的映射器代理 =》 HashMap
     */
    private final Map<Class<?>,MapperProxyFactory<?>> knownMappers = new HashMap<>();


    public void addMappers(String packageName) {
        Set<Class<?>> mapperSet = ClassScanner.scanPackage(packageName);
        for(Class<?> mapperClass : mapperSet) {
            addMapper(mapperClass);
        }
    }

    public <T> void addMapper(Class<T> type) {
        if(type.isInterface()){
            if(hasMapper(type)){
                throw new RuntimeException("Type " + type + " is already known to the MapperRegistry.");
            }
            knownMappers.put(type,new MapperProxyFactory<>(type));
        }
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        final MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>)knownMappers.get(type);
        if(mapperProxyFactory == null){
            throw new RuntimeException("Type " + type + " is not known to the MapperRegistry.");
        }
        try{
            return mapperProxyFactory.newInstance(sqlSession);
        }catch (Exception e){
            throw new RuntimeException("Error getting mapper instance. Cause: " + e, e);
        }
    }

    public boolean hasMapper(Class<?> type) {
        return knownMappers.containsKey(type);
    }
}
