package com.mie.learnMyBatis.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author: xYLiu
 * @description 事务接口
 * @date: 2024/5/1 15:18
 */

public interface Transaction {
    Connection getConnection() throws SQLException;

    void commit() throws SQLException;

    void rollback() throws SQLException;

    void close() throws SQLException;
}
