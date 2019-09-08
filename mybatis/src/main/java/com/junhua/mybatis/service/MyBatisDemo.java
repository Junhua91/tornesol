package com.junhua.mybatis.service;

import com.junhua.mybatis.mapper.TestMapper;
import com.junhua.mybatis.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class MyBatisDemo {


    public static void main(String[] args) throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("data/mybatis-config.xml");
        InputStream propertiesStream = Resources.getResourceAsStream("properties/mybatis.properties");
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();

        Properties properties = new Properties();
        properties.load(propertiesStream);

        SqlSessionFactory sessionFactory = factoryBuilder.build(inputStream, properties);

        SqlSession session = sessionFactory.openSession();
        User user = new User();
        user.setAge(12);
        user.setName("peggi");
        TestMapper mapper = session.getMapper(TestMapper.class);
        mapper.insert(user);
        List<User> users = mapper.selectAll();
        User userSelected = mapper.select("peggi");

        session.close();


    }

}
