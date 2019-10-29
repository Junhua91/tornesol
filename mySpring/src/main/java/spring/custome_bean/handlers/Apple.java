package spring.custome_bean.handlers;

import org.springframework.beans.factory.InitializingBean;

public class Apple implements InitializingBean {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init apple");
    }
}
