package com.ximalaya.webgroup.tdkservice.tdk.worker;

import com.ximalaya.webgroup.tdkservice.model.*;
import com.ximalaya.webgroup.tdkservice.tdk.api.SResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WebTDKWorker extends TDKBasicWorker {

    private StringRedisTemplate redis;

    private static Logger logger = LoggerFactory.getLogger(TDKBasicWorker.class.getName());


    @Override
    public SResult<MetaWeb> prepareResult(TDKResponse resp) {

        SResult<MetaWeb> result = new SResult<>();
        //路由判断
        switch (resp.getRet()) {
            case ConfigConstant.notFound:
                result.setRet(ConfigConstant.notFound);
                return result;
            case ConfigConstant.offline:
                result.setRet(ConfigConstant.offline);
                return result;
            case ConfigConstant.redirect:
                result.setRet(ConfigConstant.redirect);
                result.setMsg(resp.getUriOut());
                return result;
        }

        //URL的优先级最高
        List<String> uniqueCodeList = new ArrayList<>();
        uniqueCodeList.add("https://www.ximalaya.com" + resp.getUriIn());
        uniqueCodeList.add("http://www.ximalaya.com" + resp.getUriIn());
        uniqueCodeList.addAll(resp.getUniqueCodes());

        List<String> validUniqueCodeList = uniqueCodeList.stream()
                .filter(p -> getRedis().hasKey("tdk_" + p)).collect(Collectors.toList());

        if (validUniqueCodeList.isEmpty()) {
            result.setRet(ConfigConstant.invalidParams);
            result.setMsg(ConfigConstant.invalidParamsMsg);
            result.setData(genDefaultMetaWeb());
            return result;
        }

        String validUniqueCode = validUniqueCodeList.get(0);

        MetaWeb metaWeb = genMetaWeb(validUniqueCode, resp.getContext());
        result.setData(metaWeb);
        result.setRet(ConfigConstant.noError);
        return result;
    }

    @Override
    protected StringRedisTemplate getRedis() {
        return redis;
    }

    @Override
    protected List<TDKLink> parseLink(String link, String defaultLink) {
        String validLink = (link == null) ? defaultLink : link;
        List<TDKLink> result = new ArrayList<>();
        try {
            Arrays.stream(validLink.split(";"))
                    .filter(p -> isLinkValid(p))
                    .forEach(l -> {
                        String friendLink = l.trim().substring(1, l.length() - 1);
                        String[] tdkLink = friendLink.split(",");
                        if (tdkLink.length > 1)
                            result.add(new TDKLink(tdkLink[0], tdkLink[1]));
                    });
        } catch (Exception e) {
            logger.error("Exception happens while parse link", e);
        }
        return result;
    }

    @Override
    protected List<String> getReplacePatterns(String content) {
        List<String> patterns = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\{([^}]*)\\}");
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            patterns.add(matcher.group());
        }
        return patterns;
    }

    /**
     * 检查配置的连接是否符合[link]格式
     *
     * @param link
     * @return
     */
    private boolean isLinkValid(String link) {
        Pattern pattern = Pattern.compile("^\\[.*\\]$");
        Matcher matcher = pattern.matcher(link);
        return matcher.matches();
    }

    public void setRedis(StringRedisTemplate redis) {
        this.redis = redis;
    }
}
