package com.junhua.tornesol.effective.jdk.generic;

public class Request<T> {

    T content;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
