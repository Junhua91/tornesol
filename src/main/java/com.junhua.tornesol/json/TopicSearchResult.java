package com.junhua.tornesol.json;

public class TopicSearchResult {
    private TopicSearchResponse response;

    public TopicSearchResponse getResponse() {
        return response;
    }

    public void setResponse(TopicSearchResponse response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return response.toString();
    }
}
