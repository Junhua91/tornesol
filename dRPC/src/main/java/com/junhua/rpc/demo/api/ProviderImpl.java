package com.junhua.rpc.demo.api;

public class ProviderImpl implements IProvider {

    @Override
    public AlbumModel queryAlbum(Long albumId) {
        AlbumModel res = new AlbumModel();
        res.setAlbumId(1234L);
        res.setAlbumIntro("专辑介绍");
        res.setAlbumTitle("专辑标题");
        return res;
    }
}
