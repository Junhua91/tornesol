package com.ximalaya.webgroup.tdkservice.tdk.valve;

import com.ximalaya.webgroup.tdkservice.model.TDKRequest;
import com.ximalaya.webgroup.tdkservice.model.TDKResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlValve extends BaseValve {

    private List<String> groupNameList;

    public UrlValve(List<String> groupNameList) {
        this.groupNameList = groupNameList;
    }

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void invoke(TDKRequest request, TDKResponse response) {
        request.setRegex("(?<url>(?<categoryCode>[a-z0-9A-Z]+)/(?<subCategoryCode>[0-9a-zA-Z]+/)?(?<album>[0-9]+)/(?<trackId>[0-9]+)/?(?<page>p[0-9]+)?)");
        request.setUri("/yule/243433/854003/");
        Pattern pattern = Pattern.compile(request.getRegex());
        Matcher matcher = pattern.matcher(request.getUri());
        if (matcher.find()) {
            groupNameList.stream().forEach(groupName -> {
                Optional<String> groupValueOpt = Optional.empty();
                try {
                    groupValueOpt = Optional.ofNullable(matcher.group(groupName));
                } catch (IllegalArgumentException e) {
                    logger.error("exception happens while parsing url ", e);
                }
                if (groupValueOpt.isPresent()) {
                    response.getGroupMap().put(groupName, groupValueOpt.get());
                }
            });
        }
        getNext().invoke(request, response);
    }
}
