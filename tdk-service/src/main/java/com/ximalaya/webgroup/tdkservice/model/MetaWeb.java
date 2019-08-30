package com.ximalaya.webgroup.tdkservice.model;

import java.util.List;

public class MetaWeb {

    private String title;
    private String keywords;
    private String description;
    private String tips;
    private String uniqueCodes;
    private List<TDKLink> recommendation;
    private List<TDKLink> friendLink;
    private String pageConfig;
    private List<TDKLink> hotLink;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getUniqueCodes() {
        return uniqueCodes;
    }

    public void setUniqueCodes(String uniqueCodes) {
        this.uniqueCodes = uniqueCodes;
    }

    public List<TDKLink> getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(List<TDKLink> recommendation) {
        this.recommendation = recommendation;
    }

    public List<TDKLink> getFriendLink() {
        return friendLink;
    }

    public void setFriendLink(List<TDKLink> friendLink) {
        this.friendLink = friendLink;
    }

    public String getPageConfig() {
        return pageConfig;
    }

    public void setPageConfig(String pageConfig) {
        this.pageConfig = pageConfig;
    }

    public List<TDKLink> getHotLink() {
        return hotLink;
    }

    public void setHotLink(List<TDKLink> hotLink) {
        this.hotLink = hotLink;
    }
}
