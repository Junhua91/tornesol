package main.com.junhua.tournesol.mymvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ExtDispatcherServlet extends HttpServlet {

    private ConcurrentHashMap<String, Object> springMvcBeans = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Object> urlBeans = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, String> methodBeans = new ConcurrentHashMap<>();


    @Override
    public void init() throws ServletException {

        List<Class<?>> classes = ClassUtil.getClasses("main.com.junhua.tournesol.mymvc");
        try {
            findMVCClasses(classes);
            findHandleMapping();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void findMVCClasses(List<Class<?>> classes) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        for (Class<?> clazz : classes) {
            ExtController controller = clazz.getDeclaredAnnotation(ExtController.class);
            if (controller != null) {
                String beanName = ClassUtil.toLowerCaseFirstOne(clazz.getSimpleName());
                Object bean = ClassUtil.newInstance(clazz.getName(), new HashMap<>());
                springMvcBeans.put(beanName, bean);
            }
        }
    }

    public void findHandleMapping() {
        springMvcBeans.entrySet().forEach(entry -> {
            Object bean = entry.getValue();
            Class<?> classInfo = bean.getClass();
            ExRequestMapping requestMapping = classInfo.getDeclaredAnnotation(ExRequestMapping.class);
            String baseUrl = "";
            if (requestMapping != null) {
                baseUrl = requestMapping.value();
            }
            Method[] methods = classInfo.getDeclaredMethods();
            for (Method method : methods) {
                ExRequestMapping exRequestMapping = method.getDeclaredAnnotation(ExRequestMapping.class);
                if (exRequestMapping != null) {
                    String url = baseUrl + exRequestMapping.value();
                    urlBeans.put(url, bean);
                    methodBeans.put(url, method.getName());
                }
            }
        });
    }

    private void extResourceViewResolver(String pathName, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String prefix = "/";
        String suffix = ".jsp";
        req.getRequestDispatcher(prefix + pathName + suffix).forward(req, res);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = req.getRequestURI();
        Object obj = urlBeans.get(url);

        if (obj == null) {
            resp.getWriter().println("404");
            return;
        }

        String methodName = methodBeans.get(url);
        if (methodName == null) {
            resp.getWriter().println("Can't find such method");
            return;
        }

        extResourceViewResolver(invokeMethod(obj, methodName), req, resp);
    }

    public String invokeMethod(Object obj, String methodName) {
        String result = null;
        try {
            Class<?> classInfo = obj.getClass();
            result = (String) classInfo.getDeclaredMethod(methodName).invoke(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return result;
    }

}
