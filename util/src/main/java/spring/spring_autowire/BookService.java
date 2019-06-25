package spring.spring_autowire;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    @Qualifier("bookDao2")
    public BookDao bookDao;
}
