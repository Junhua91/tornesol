package custom;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class MyInvocationHandler<T> implements InvocationHandler {

    T target;

    public MyInvocationHandler(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        extInsert(proxy, method, args);
        return extSelect(proxy, method, args);

    }

    private Object extSelect(Object proxy, Method method, Object[] args) throws SQLException, IllegalAccessException, InstantiationException {

        ExtSelect selectAnnotation = method.getAnnotation(ExtSelect.class);
        if (selectAnnotation != null) {
            String sql = selectAnnotation.value();
            Map<Object, Object> paramMap = new ConcurrentHashMap();

            getMethodParameterMap(method, args, paramMap);

            List<String> paramNames = SQLUtils.sqlSelectParameter(sql);

            List params = paramNames.stream().map(paraName -> {
                Object paraValue = paramMap.get(paraName);
                return paraValue;
            }).collect(Collectors.toList());

            String newSql = SQLUtils.parameQuestion(sql, paramNames);

            ResultSet res = JDBCUtils.query(newSql, params);

            res.previous();

            //获取select返回类型
            Class<?> returnType = method.getReturnType();

            //创建一个返回类型的实例对象
            Object returnObject = returnType.newInstance();

            //给实例对象添加属性
            while (res.next()) {
                Arrays.stream(returnType.getDeclaredFields()).forEach(field -> {
                    try {
                        String name = field.getName();
                        Object fieldValue = res.getObject(name);
                        field.setAccessible(true);

                        if (field.getType() == Integer.class)
                            fieldValue = Integer.parseInt(fieldValue.toString());
                        field.set(returnObject, fieldValue);

                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
            }

            return returnObject;
        }

        return null;
    }

    private int extInsert(Object proxy, Method method, Object[] args) {

        //判断方法是否使用来了ExtInsert注解
        ExtInsert insertAnnotation = method.getAnnotation(ExtInsert.class);

        if (insertAnnotation != null) {
            String sql = insertAnnotation.value();

            //用于存储方法的参数名字，参数值的键值对
            Map<Object, Object> paramMap = new ConcurrentHashMap();
            getMethodParameterMap(method, args, paramMap);

            //找到sql语句中的变量名
            String[] insertParams = SQLUtils.sqlInsertParameter(sql);

            //获取变量的值
            List params = Arrays.stream(insertParams).map(param -> {
                String objName = param.split("\\.")[0].trim();
                String methodName = param.split("\\.")[1];

                Object obj = paramMap.get(objName);

                Object getValue = null;
                //使用反射，调用get方法获取属性值
                try {
                    getValue = obj.getClass().getMethod(methodName).invoke(obj);
                    return getValue;
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                return getValue;
            }).collect(Collectors.toList());

            //用问号代替sql语句中的变量
            String newSql = SQLUtils.parameQuestion(sql, insertParams);
            System.out.println(newSql);

            //执行sql语句
            int r = JDBCUtils.insert(newSql, false, params);
            return r;
        }
        return -1;
    }

    private void getMethodParameterMap(Method method, Object[] args, Map<Object, Object> paramMap) {
        Parameter[] parameters = method.getParameters();

        for (int i = 0; i < parameters.length; i++) {
            Parameter param = parameters[i];
            ExtParam extParam = param.getAnnotation(ExtParam.class);
            if (extParam != null) {
                String paraName = extParam.value();
                Object value = args[i];
                paramMap.put(paraName, value);
            }
        }
    }
}
