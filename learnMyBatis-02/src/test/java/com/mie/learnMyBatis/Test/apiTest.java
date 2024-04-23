package com.mie.learnMyBatis.Test;

import com.mie.learnMyBatis.Test.dao.IStudentDao;
import com.mie.learnMyBatis.binding.MapperProxyFactory;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 3A87
 * @description
 * @date 2024/4/22
 */
public class apiTest {
    @Test
    public void test_MapperProxyFactory(){
        MapperProxyFactory<IStudentDao> factory = new MapperProxyFactory<>(IStudentDao.class);
        Map<String,String> sqlSession = new HashMap<>();
        sqlSession.put("com.mie.learnMyBatis.Test.dao.IStudentDao.queryStudentName","模拟执行 Mapper.xml 中 SQL 语句的操作：查询学生姓名");
        sqlSession.put("com.mie.learnMyBatis.Test.dao.IStudentDao.queryStudentAge","模拟执行 Mapper.xml 中 SQL 语句的操作：查询学生年龄");
        IStudentDao studentDao = factory.newInstance(sqlSession);

        String res = studentDao.queryStudentName("小芳");
        System.out.println(res);

    }
}
