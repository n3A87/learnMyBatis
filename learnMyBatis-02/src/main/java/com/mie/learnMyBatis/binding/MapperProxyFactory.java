package com.mie.learnMyBatis.binding;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @author 3A87
 * @description 映射器代理工厂
 * @date 2024/4/22
 */
public class MapperProxyFactory<T> {
    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public T newInstance(Map<String,String> sqlSession){
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession,mapperInterface);
        //三个参数：获取目标类的类加载器、告诉代理类要实现哪些接口、调用处理器
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(),new Class[]{mapperInterface},mapperProxy);
    }
}
