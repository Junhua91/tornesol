package com.junhua.mustache;

import java.util.List;

public class MustacheModel<T> {

    private List<T> items;
    private T item;

    public MustacheModel(List<T> items, T item) {
        this.items = items;
        this.item = item;
    }

    public List<T> items() {
        return items;
    }

    public T item() {
        return item;
    }
}
