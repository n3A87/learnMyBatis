package com.mie.learnMyBatis.transaction;

import org.apache.ibatis.session.TransactionIsolationLevel;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author: xYLiu
 * @description 事务工厂
 * @date: 2024/5/1 15:19
 */

public interface TransactionFactory {

    /**
     * 根据 Connection 创建 Transaction
     * @param conn
     * @return
     */
    Transaction newTransaction(Connection conn);

    /**
     * 根据数据源和事务隔离级别创建Transaction
     * @param dataSource
     * @param level
     * @param autoCommit
     * @return
     */
    Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level,boolean autoCommit);


}
