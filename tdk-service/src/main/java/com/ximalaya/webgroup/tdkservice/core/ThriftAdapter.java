package com.ximalaya.webgroup.tdkservice.core;


import com.ximalaya.service.album.api.IAlbumFacadeHandler;
import com.ximalaya.service.profile.thrift.RemoteUserInfoQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThriftAdapter {

    @Autowired
    private IAlbumFacadeHandler.Iface albumService;


    @Autowired
    private RemoteUserInfoQueryService.Iface profileService;

    public IAlbumFacadeHandler.Iface getAlbumService() {
        return albumService;
    }

    public RemoteUserInfoQueryService.Iface getProfileService() {
        return profileService;
    }
}
