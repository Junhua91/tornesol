package custom;

import model.User;

public interface ExtMapper {

    @ExtInsert("insert into mybatis(name,age) values (#{user.getName},#{user.getAge})")
    void insert(@ExtParam("user") User user);

    @ExtSelect("select name,age from mybatis where name=#{name}")
    User select(@ExtParam("name") String name);

}
