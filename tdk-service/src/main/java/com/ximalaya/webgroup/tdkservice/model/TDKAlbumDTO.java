package com.ximalaya.webgroup.tdkservice.model;

public class TDKAlbumDTO {

    private String albumId;
    private String albumTitle;
    private String albumIntro;
    private String nickName;
    private String categoryTitle;

    public TDKAlbumDTO() {
        this.albumId = "";
        this.albumTitle = "";
        this.albumIntro = "";
        this.nickName = "";
        this.categoryTitle = "";
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public String getAlbumIntro() {
        return albumIntro;
    }

    public void setAlbumIntro(String albumIntro) {
        this.albumIntro = albumIntro;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }
}
