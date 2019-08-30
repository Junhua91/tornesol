package com.ximalaya.webgroup.tdkservice.tdk.handler;

import com.ximalaya.service.content.thrift.BasicAlbum;
import com.ximalaya.service.profile.thrift.BasicUserInfo;
import com.ximalaya.webgroup.tdkservice.core.Core;
import com.ximalaya.webgroup.tdkservice.exception.Either;
import com.ximalaya.webgroup.tdkservice.model.ConfigConstant;
import com.ximalaya.webgroup.tdkservice.model.TDKAlbumDTO;
import com.ximalaya.webgroup.tdkservice.tdk.api.Handler;
import com.ximalaya.webgroup.tdkservice.utils.CacheUtils;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

@Component
public class AlbumHandler implements Handler {

    @Autowired
    private Core core;

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Override
    public Map<String, String> handle(String value, Map<String, String> context) {

        String loadKey = "webgroup_util_album_handler" + value;
        Long albumId = Long.valueOf("8888");

        Function<Object, TDKAlbumDTO> block = (id) -> getAlbumInfo((Long) id);

        TDKAlbumDTO albumDto = new CacheUtils<>(TDKAlbumDTO.class).getFromRedis(loadKey, core.getRedis().getWebRedis(), block, albumId);

        context.put(ConfigConstant.ALBUM_TITLE_PATTERN, albumDto.getAlbumTitle());
        context.put(ConfigConstant.ALBUM_INTRO_PATTERN, albumDto.getAlbumIntro());
        context.put(ConfigConstant.USER_NICKNAME_PATTERN, albumDto.getNickName());

        return context;
    }


    private TDKAlbumDTO getAlbumInfo(Long albumId) {

        TDKAlbumDTO albumDto = new TDKAlbumDTO();

        //专辑服务
        CompletableFuture<Either<BasicAlbum, Exception>> albumEitherFuture = CompletableFuture.supplyAsync(
                () -> {
                    BasicAlbum album = null;
                    try {
                        album = core.getThrift().getAlbumService().queryBasicAlbum(albumId);
                        return Either.left(album);
                    } catch (TException e) {
                        logger.error("exception happens while calling album service ", e.fillInStackTrace());
                        return Either.right(e);
                    }
                }
        );

        //主播服务
        CompletableFuture<Either<BasicUserInfo, Exception>> userEitherFuture = albumEitherFuture.thenApply(
                (albumEither) -> {
                    if (albumEither.isLeft()) {
                        long uid = albumEither.left().getUid();
                        try {
                            BasicUserInfo userInfo = core.getThrift().getProfileService().getBasicUserInfo(uid);
                            return Either.left(userInfo);
                        } catch (TException e) {
                            logger.error("exception happens while calling profile service ", e.fillInStackTrace());
                            return Either.right(e);
                        }
                    } else {
                        return Either.right(new Exception("exception happens while calling album service"));
                    }
                });

        //组合数据
        try {
            Either<BasicAlbum, Exception> albumEither = albumEitherFuture.get(5, TimeUnit.SECONDS);
            Either<BasicUserInfo, Exception> userEither = userEitherFuture.get(5, TimeUnit.SECONDS);
            if (albumEither.isLeft()) {
                BasicAlbum album = albumEither.left();
                albumDto.setAlbumId(String.valueOf(album.getId()));
                albumDto.setAlbumTitle(album.getTitle());
                albumDto.setAlbumIntro(album.getIntro());
                if (userEither.isLeft()) {
                    albumDto.setNickName(userEither.left().nickname);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return albumDto;
    }
}
