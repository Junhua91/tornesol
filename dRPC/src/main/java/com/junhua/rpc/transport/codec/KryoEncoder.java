package com.junhua.rpc.transport.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class KryoEncoder extends MessageToByteEncoder<Object> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
        KryoSerializer.serialize(o, byteBuf);
        channelHandlerContext.flush();
    }
}
