package com.ximalaya.webgroup.tdkservice.tdk.worker;

import com.ximalaya.webgroup.tdkservice.model.*;
import com.ximalaya.webgroup.tdkservice.tdk.api.SResult;
import com.ximalaya.webgroup.tdkservice.utils.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 提供解析TDK的基本操作
 */
public abstract class TDKBasicWorker {

    private static Logger logger = LoggerFactory.getLogger(TDKBasicWorker.class.getName());
    protected static MetaRedis DEFAULT_META_REDIS = new MetaRedis();

    //默认的MetaRedis
    static {
        DEFAULT_META_REDIS.setTitle(ConfigConstant.defaultTitle);
        DEFAULT_META_REDIS.setKeyword(ConfigConstant.defaultKey);
        DEFAULT_META_REDIS.setDescription(ConfigConstant.defaultDesc);
        DEFAULT_META_REDIS.setTips(ConfigConstant.defaultTips);
        DEFAULT_META_REDIS.setRecommendation(ConfigConstant.defaultRecommendation);
        DEFAULT_META_REDIS.setFriendLink(ConfigConstant.defaultFriendLinks);
        DEFAULT_META_REDIS.setHotLink(ConfigConstant.defaultHot);
        DEFAULT_META_REDIS.setPageConfig(ConfigConstant.defaultPageConfig);
        DEFAULT_META_REDIS.setUniqueCodes(ConfigConstant.defaultUniqueCode);
    }

    /**
     * 生成输出结果
     *
     * @param resp
     * @return
     */
    public abstract SResult<MetaWeb> prepareResult(TDKResponse resp);

    protected MetaWeb genMetaWeb(String key, Map context) {
        MetaRedis metaRedis = loadDataFromRedis(key);
        return parseMeta(context, metaRedis);
    }

    protected MetaWeb genDefaultMetaWeb() {
        return parseMeta(Collections.emptyMap(), DEFAULT_META_REDIS);
    }

    /**
     * 指定redis
     *
     * @return
     */
    protected abstract StringRedisTemplate getRedis();

    /**
     * 自定义链接解析：友情链接；推荐链接；热门链接 ...
     *
     * @param link
     * @param defaultLink
     * @return
     */
    protected abstract List<TDKLink> parseLink(String link, String defaultLink);

    /**
     * 自定义文字替换模版
     *
     * @param content
     * @return
     */
    protected abstract List<String> getReplacePatterns(String content);

    /**
     * 从redis中读取TDK的信息；在数据为空的情况下，或者发生异常的情况下，返回一个默认值
     *
     * @param key
     * @return
     */

    private MetaRedis loadDataFromRedis(String key) {
        String redisKey = "tdk_" + key;
        MetaRedis meta = null;

        StringRedisTemplate redis = getRedis();

        try {
            boolean isExist = redis.hasKey(redisKey);
            if (isExist) {
                String redisStr = redis.opsForValue().get(redisKey);
                meta = JSONUtils.parseJson(redisStr, MetaRedis.class);
            }
        } catch (Exception e) {
            logger.error("exception happens while getting TDK data from redis ", e.getStackTrace());
        }

        return (meta == null) ? DEFAULT_META_REDIS : meta;
    }

    /**
     * 解析文字信息：title，keywords，description，tips...
     *
     * @param content
     * @param defaultContent
     * @param context
     * @return
     */
    private String parseText(String content, String defaultContent, Map<String, String> context) {

        if (content == null) return defaultContent;

        List<String> patterns = getReplacePatterns(content);

        if (patterns.isEmpty()) return content;

        for (String pattern : patterns) {
            String value = context.get(pattern);
            if (value == null) value = "";
            content = content.replace(pattern, value);
        }

        return content;
    }

    private MetaWeb parseMeta(Map context, MetaRedis metaRedis) {
        MetaWeb metaWeb = new MetaWeb();
        String title = parseText(metaRedis.getTitle(), ConfigConstant.defaultTitle, context);
        String keyword = parseText(metaRedis.getKeyword(), ConfigConstant.defaultKey, context);
        String description = parseText(metaRedis.getDescription(), ConfigConstant.defaultDesc, context);
        String tips = parseText(metaRedis.getTips(), ConfigConstant.defaultTips, context);
        String pageConfig = parseText(metaRedis.getPageConfig(), ConfigConstant.defaultPageConfig, context);

        List<TDKLink> friendLink = parseLink(metaRedis.getFriendLink(), ConfigConstant.defaultFriendLinks);
        List<TDKLink> hotLink = parseLink(metaRedis.getHotLink(), ConfigConstant.defaultHot);
        List<TDKLink> recommendation = parseLink(metaRedis.getRecommendation(), ConfigConstant.defaultRecommendation);

        metaWeb.setTitle(title);
        metaWeb.setKeywords(keyword);
        metaWeb.setDescription(description);
        metaWeb.setTips(tips);
        metaWeb.setPageConfig(pageConfig);

        metaWeb.setFriendLink(friendLink);
        metaWeb.setHotLink(hotLink);
        metaWeb.setRecommendation(recommendation);

        return metaWeb;
    }
}
