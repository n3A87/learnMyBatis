package com.mie.learnMyBatis.datasource.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.mie.learnMyBatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author: xYLiu
 * @description Druid数据源工厂
 * @date: 2024/5/1 15:55
 */

public class DruidDataSourceFactory implements DataSourceFactory {
    private Properties props;

    @Override
    public void setProperties(Properties props) {
        this.props = props;
    }

    @Override
    public DataSource getDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(props.getProperty("driver"));
        druidDataSource.setUrl(props.getProperty("url"));
        druidDataSource.setUsername(props.getProperty("username"));
        druidDataSource.setPassword(props.getProperty("password"));
        return druidDataSource;
    }
}
