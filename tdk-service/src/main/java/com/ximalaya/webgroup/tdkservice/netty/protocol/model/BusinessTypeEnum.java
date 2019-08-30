package com.ximalaya.webgroup.tdkservice.netty.protocol.model;

public enum BusinessTypeEnum {

    SERVICE_REQ(0),/*业务请求消息*/
    SERVICE_RESP(1), /*业务应答消息*/
    ONE_WAY(2), /*无需应答的消息*/
    LOGIN_REQ(3), /*登录请求消息*/
    LOGIN_RESP(4), /*登录响应消息*/
    HEARTBEAT_REQ(5), /*心跳请求消息*/
    HEARTBEAT_RESP(6);/*心跳应答消息*/

    private int type;

    BusinessTypeEnum(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
