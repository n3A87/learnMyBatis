package com.mie.learnMyBatis.Test;

import com.alibaba.fastjson.JSON;
import com.mie.learnMyBatis.Test.dao.IUserDao;
import com.mie.learnMyBatis.Test.po.User;
import com.mie.learnMyBatis.io.Resources;
import com.mie.learnMyBatis.session.SqlSession;
import com.mie.learnMyBatis.session.SqlSessionFactory;
import com.mie.learnMyBatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author 3A87
 * @description
 * @date 2024/4/22
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);
    @Test
    public void test_SqlSessionFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        User user = userDao.queryUserInfoById(1L);
        logger.info("测试结果：{}", JSON.toJSONString(user));
    }
}
