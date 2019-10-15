package com.junhua.http.api;

import java.util.List;

public interface IDataProvider<T> {


    /**
     * 使用方提供数据
     *
     * @return
     */
    List<T> provide();

}
