package com.ximalaya.webgroup.tdkservice.tdk.valve;

import com.ximalaya.webgroup.tdkservice.model.TDKRequest;
import com.ximalaya.webgroup.tdkservice.model.TDKResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 处理结果的最后一步，发送结果
 */
@Component
public class BasicValve extends BaseValve {


    private static Logger logger = LoggerFactory.getLogger(BasicValve.class);

    @Override
    public void invoke(TDKRequest request, TDKResponse response) {

        logger.error(String.valueOf(response.getResult().getRet()));
    }
}
