package com.junhua.tornesol.util.spring.spring_event;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate template;

    public void insert() {
        String sql = "insert into admin (nickname,password) values(?,?)";
        template.update(sql, "peipeis", "love");
        System.out.println("insert finish");
    }
}
