package com.mie.learnMyBatis.binding;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

import com.mie.learnMyBatis.session.SqlSession;

/**
 * @author 3A87
 * @description 映射器代理类
 * @date 2024/4/22
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {
    //序列化Id:判定版本的一致性
    private static final long serialVersionUID = -6424540398559729838L;

    private SqlSession sqlSession;
    private final Class<T> mapperInterface;

    public MapperProxy(SqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Object 提供的 toString、hashCode 等方法是不需要代理执行的
        if(Object.class.equals(method.getDeclaringClass())){
            return method.invoke(this,args);
        }else{
            return "你被代理了!"+sqlSession.selectOne(mapperInterface.getName()+"."+method.getName());
        }
    }
}
