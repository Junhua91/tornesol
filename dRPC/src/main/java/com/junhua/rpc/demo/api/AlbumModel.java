package com.junhua.rpc.demo.api;

public class AlbumModel {

    private Long albumId;
    private String albumTitle;
    private String albumIntro;

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
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
}
