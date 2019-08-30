package com.ximalaya.webgroup.tdkservice.netty.protocol.utils;

import com.ximalaya.webgroup.tdkservice.netty.protocol.model.BusinessTypeEnum;
import com.ximalaya.webgroup.tdkservice.netty.protocol.model.MessageProto;

import java.util.Map;

public class MessageUtils {

    public static MessageProto.messageProto createMessage(
            int priority, Long sessionId, BusinessTypeEnum messageType, int crcCode,
            Map<String, String> attachment, String body) {

        MessageProto.messageProto.Builder builder = MessageProto.messageProto.newBuilder();
        MessageProto.headerProto.Builder headerBuider = MessageProto.headerProto.newBuilder();
        if (!attachment.isEmpty()) {
            attachment.entrySet().stream().forEach(entry ->
                    headerBuider.putAttachment(entry.getKey(), entry.getValue())
            );
        }
        int attachmentCount = headerBuider.getAttachmentCount();
        headerBuider.setPriority(priority);
        headerBuider.setType(messageType.getType());
        headerBuider.setSessionID(sessionId);
        headerBuider.setCrcCode(crcCode);
        headerBuider.setLength(24 + attachmentCount);
        builder.setHeader(headerBuider.build());
        builder.setBody(body);
        return builder.build();
    }
}
