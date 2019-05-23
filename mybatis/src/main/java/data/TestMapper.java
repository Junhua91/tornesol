package data;

import model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestMapper {

    void insert(@Param("user") User user);

    User select(@Param("name") String name);

    List<User> selectAll();
}
