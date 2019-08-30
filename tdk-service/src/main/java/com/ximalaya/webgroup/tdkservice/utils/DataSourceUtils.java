package com.ximalaya.webgroup.tdkservice.utils;

import com.ximalaya.webgroup.tdkservice.core.db.DbConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.util.Properties;

public class DataSourceUtils {

    static public DataSource createDataSource(DbConfig config) {

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
        hikariConfig.setJdbcUrl(String.format("jdbc:mysql://%s/%s", config.getHost(), config.getDatabase()));
        hikariConfig.setUsername(config.getUsername());
        hikariConfig.setPassword(config.getPassword());

        Properties properties = new Properties();
        properties.setProperty("cachePrepStmts", "true");
        properties.setProperty("prepStmtCacheSize", "250");
        properties.setProperty("prepStmtCacheSqlLimit", "2408");
        hikariConfig.setDataSourceProperties(properties);
        return new HikariDataSource(hikariConfig);

    }
}
