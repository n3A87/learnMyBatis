package com.mie.learnMyBatis.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author: xYLiu
 * @description 数据源工厂
 * @date: 2024/5/1 15:54
 */

public interface DataSourceFactory {
    void setProperties(Properties props);

    DataSource getDataSource();
}
