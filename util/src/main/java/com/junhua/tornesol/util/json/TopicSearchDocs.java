package com.junhua.tornesol.util.json;

public class TopicSearchDocs {

    private String title;
    private int id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("id = %d, title= %s", id, title);
    }
}
