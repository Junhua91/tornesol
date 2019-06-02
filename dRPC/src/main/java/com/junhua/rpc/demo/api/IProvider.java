package com.junhua.rpc.demo.api;

/**
 * 服务提供者接口
 */
public interface IProvider {
    AlbumModel queryAlbum(Long albumId);
}
