package spring.spring_event;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    @Transactional//表示当前方法是事务方法
    public void insert() {
        userDao.insert();
        int i = 10 / 0;
    }
}
