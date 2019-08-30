package com.ximalaya.webgroup.tdkservice.core.db.mybatis;


import com.ximalaya.webgroup.tdkservice.core.db.DbConfig;
import com.ximalaya.webgroup.tdkservice.core.db.mybatis.intercept.MyFirstPlugin;
import com.ximalaya.webgroup.tdkservice.core.db.mybatis.intercept.MySecondPlugin;
import com.ximalaya.webgroup.tdkservice.utils.DataSourceUtils;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MybatisConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "db.webgroup")
    public DbConfig webDbConfig() {
        return new DbConfig();
    }

    @Bean
    @ConfigurationProperties(prefix = "db.ops")
    public DbConfig opsConfig() {
        return new DbConfig();
    }


    @Bean
    @ConfigurationProperties(prefix = "db.local")
    public DbConfig localConfig() {
        return new DbConfig();
    }

    @Bean
    public Interceptor myFirstPlugin() {
        return new MyFirstPlugin();
    }


    @Bean
    public Interceptor mySecondPlugin() {
        return new MySecondPlugin();
    }

    @Bean
    public RoutingDataSource dataSource() {

        DataSource webGroupDataSource = DataSourceUtils.createDataSource(webDbConfig());
        DataSource opsDataSource = DataSourceUtils.createDataSource(opsConfig());
        DataSource localDataSource = DataSourceUtils.createDataSource(localConfig());

        RoutingDataSource dataSource = new RoutingDataSource();
        Map<Object, Object> targetSources = new HashMap<>();
        targetSources.put("web_group", webGroupDataSource);
        targetSources.put("ops", opsDataSource);
        targetSources.put("local", localDataSource);
        dataSource.setTargetDataSources(targetSources);
        dataSource.setDefaultTargetDataSource(webGroupDataSource);
        return dataSource;
    }


    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        Interceptor[] plugins = new Interceptor[]{mySecondPlugin(), myFirstPlugin()};
        sqlSessionFactoryBean.setPlugins(plugins);

        return sqlSessionFactoryBean;
    }
}
