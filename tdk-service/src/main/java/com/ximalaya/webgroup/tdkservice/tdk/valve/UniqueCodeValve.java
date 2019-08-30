package com.ximalaya.webgroup.tdkservice.tdk.valve;

import com.ximalaya.webgroup.tdkservice.model.ConfigConstant;
import com.ximalaya.webgroup.tdkservice.model.TDKRequest;
import com.ximalaya.webgroup.tdkservice.model.TDKResponse;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class UniqueCodeValve extends BaseValve {


    @Override
    public void invoke(TDKRequest request, TDKResponse response) {

        if (StringUtils.isEmpty(request.getUniqueCode()) || request.getUniqueCode() == "") {
            response.setUniqueCodes(Arrays.asList(ConfigConstant.defaultUniqueCode));
            getNext().invoke(request, response);
        } else {
            List uniqueCodeList = new ArrayList<>();
            Arrays.stream(request.getUniqueCode().split(",")).forEach(uniqueCode -> {
                uniqueCodeList.add(buildNewUniqueCode(uniqueCode, response.getGroupMap()));
            });
            response.setUniqueCodes(uniqueCodeList);
            getNext().invoke(request, response);
        }
    }

    private String buildNewUniqueCode(String uniqueCode, Map<String, String> groupMap) {
        if (groupMap.isEmpty()) {
            return uniqueCode;
        }
        String newUniqueCode = uniqueCode;
        for (Map.Entry<String, String> entry : groupMap.entrySet()) {
            String groupName = entry.getKey();
            String groupValue = entry.getValue();
            newUniqueCode = newUniqueCode.replaceAll(groupName, groupValue);
        }
        return newUniqueCode;
    }

}
