package com.junhua.tornesol.util.json;

import java.util.List;

public class TopicSearchResponse {

    private List<TopicSearchDocs> docs;
    private int numFound;
    private int totalPage;

    public List<TopicSearchDocs> getDocs() {
        return docs;
    }

    public void setDocs(List<TopicSearchDocs> docs) {
        this.docs = docs;
    }

    public int getNumFound() {
        return numFound;
    }

    public void setNumFound(int numFound) {
        this.numFound = numFound;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (TopicSearchDocs doc : docs) {
            sb.append(String.format("{%s}", doc.toString()));
        }
        sb.append("]");
        return sb.toString();
    }
}
