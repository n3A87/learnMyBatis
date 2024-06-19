package com.mie.learnMyBatis.Test;

import com.mie.learnMyBatis.Test.dao.IStudentDao;
import com.mie.learnMyBatis.binding.MapperRegistry;
import com.mie.learnMyBatis.session.SqlSession;
import com.mie.learnMyBatis.session.SqlSessionFactory;
import com.mie.learnMyBatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.Test;

import static com.mysql.cj.conf.PropertyKey.logger;


/**
 * @author 3A87
 * @description
 * @date 2024/4/22
 */
public class apiTest {
    @Test
    public void test_MapperProxyFactory() {
        // 1. 注册 Mapper
        MapperRegistry registry = new MapperRegistry();
        registry.addMappers("com.mie.learnMyBatis.Test.dao");

        // 2. 从 SqlSession 工厂获取 Session
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取映射器对象
        IStudentDao userDao = sqlSession.getMapper(IStudentDao.class);

        // 4. 测试验证
        String res = userDao.queryStudentName("小芳");
    }
}
