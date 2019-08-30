package com.ximalaya.webgroup.tdkservice.core.db.mybatis.intercept;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

@Intercepts({@Signature(type = Executor.class, method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class MySecondPlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        Object proxy = Plugin.wrap(target, this);
        return proxy;
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("插件的配置信息2:" + properties);
    }
}
