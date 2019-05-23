package main.com.junhua.tournesol.myservlet;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("my filter");

        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}
