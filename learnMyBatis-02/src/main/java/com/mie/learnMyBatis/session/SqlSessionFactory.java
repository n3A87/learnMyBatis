package com.mie.learnMyBatis.session;

public interface SqlSessionFactory {
    /**
     * 打开一个session
     * @return
     */
    SqlSession openSession();
}
