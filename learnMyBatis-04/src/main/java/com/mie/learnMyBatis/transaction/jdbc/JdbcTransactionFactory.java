package com.mie.learnMyBatis.transaction.jdbc;

import com.mie.learnMyBatis.transaction.Transaction;
import com.mie.learnMyBatis.transaction.TransactionFactory;
import org.apache.ibatis.session.TransactionIsolationLevel;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author: xYLiu
 * @description JdbcTransaction 工厂
 * @date: 2024/5/1 15:21
 */

public class JdbcTransactionFactory implements TransactionFactory {
    @Override
    public Transaction newTransaction(Connection conn) {
        return new JdbcTransaction(conn);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new JdbcTransaction(dataSource,level,autoCommit);
    }
}
