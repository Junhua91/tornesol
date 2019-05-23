package main.com.junhua.tournesol.myservlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {


    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized...");

    }

    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println("contextDestroyed...");

    }
}
