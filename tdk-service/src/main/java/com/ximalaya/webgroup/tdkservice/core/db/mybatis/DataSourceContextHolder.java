package com.ximalaya.webgroup.tdkservice.core.db.mybatis;

public class DataSourceContextHolder {

    private static final ThreadLocal<String> dsKeyHolder = new ThreadLocal<String>();

    public static String getDataSourceKey() {
        return dsKeyHolder.get();
    }

    public static void setDataSourceKey(String key) {
        dsKeyHolder.set(key);
    }

    public static void clearDataSourceKey() {
        dsKeyHolder.remove();
    }

}