package com.ximalaya.webgroup.tdkservice.netty.protocol.codec;

import com.google.protobuf.InvalidProtocolBufferException;
import com.ximalaya.webgroup.tdkservice.netty.protocol.model.BusinessTypeEnum;
import com.ximalaya.webgroup.tdkservice.netty.protocol.model.MessageProto;

public class TestProtoCodec {

    public byte[] encode(MessageProto.messageProto messageProto) {
        return messageProto.toByteArray();
    }

    public MessageProto.messageProto decode(byte[] body) throws InvalidProtocolBufferException {
        return MessageProto.messageProto.parseFrom(body);
    }

    public MessageProto.messageProto createMessage() {
        MessageProto.messageProto.Builder builder = MessageProto.messageProto.newBuilder();
        MessageProto.headerProto.Builder headerBuider = MessageProto.headerProto.newBuilder();
        headerBuider.putAttachment("testKey", "testValue");
        int attachmentCount = headerBuider.getAttachmentCount();
        headerBuider.setLength(24 + attachmentCount);
        headerBuider.setPriority(1);
        headerBuider.setType(BusinessTypeEnum.LOGIN_REQ.getType());
        headerBuider.setPriority(1);
        headerBuider.setSessionID(21212);
        headerBuider.setCrcCode(1111);
        builder.setHeader(headerBuider.build());
        builder.setBody("这是测试body");
        return builder.build();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        TestProtoCodec testProtoCodec = new TestProtoCodec();
        MessageProto.messageProto message = testProtoCodec.createMessage();
        System.out.println("after encode  lenght:" + testProtoCodec.encode(message).length);

        System.out.println(testProtoCodec.decode(testProtoCodec.encode(message)).equals(message));

    }
}
