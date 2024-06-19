package com.mie.learnMyBatis.Test;

import com.google.protobuf.Api;
import com.mie.learnMyBatis.Test.dao.IStudentDao;
import com.mie.learnMyBatis.binding.MapperProxyFactory;
import com.mie.learnMyBatis.io.Resources;
import com.mie.learnMyBatis.session.SqlSession;
import com.mie.learnMyBatis.session.SqlSessionFactory;
import com.mie.learnMyBatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 3A87
 * @description
 * @date 2024/4/22
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);
    @Test
    public void test_SqlSessionFactory() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        IStudentDao studentDao = sqlSession.getMapper(IStudentDao.class);

        String res = studentDao.queryStudentInfoById("小芳");
        logger.info("测试结果：{}",res);
    }
}
