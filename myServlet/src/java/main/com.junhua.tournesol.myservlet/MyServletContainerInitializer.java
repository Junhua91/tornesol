package main.com.junhua.tournesol.myservlet;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;

@HandlesTypes(IServlet.class)
public class MyServletContainerInitializer implements ServletContainerInitializer {


    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {

        System.out.println("classes interests");
        for (Class<?> claz : c) {
            System.out.println(claz);
        }

        ServletRegistration.Dynamic servlet = ctx.addServlet("myServlet", new MyServlet());
        servlet.addMapping("/myServlet2");

        FilterRegistration.Dynamic filter = ctx.addFilter("myFilter", MyFilter.class);
        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");

        ctx.addListener(MyListener.class);

    }

}
