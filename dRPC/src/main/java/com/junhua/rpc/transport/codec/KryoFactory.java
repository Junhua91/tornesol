package com.junhua.rpc.transport.codec;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.serializers.DefaultSerializers;
import com.junhua.rpc.transport.model.Request;
import com.junhua.rpc.transport.model.Response;
import com.junhua.rpc.transport.model.RpcInvocation;

import java.util.Arrays;
import java.util.GregorianCalendar;

public class KryoFactory {

    public static Kryo createKryo() {
        Kryo kryo = new Kryo();
        kryo.setRegistrationRequired(false);
        kryo.register(Arrays.asList("").getClass(), new DefaultSerializers.ArraysAsListSerializer());
        kryo.register(GregorianCalendar.class);
        kryo.register(StringBuffer.class);
        kryo.register(StringBuilder.class);
        kryo.register(Object.class);
        kryo.register(Object[].class);
        kryo.register(String[].class);
        kryo.register(byte[].class);
        kryo.register(char[].class);
        kryo.register(int[].class);
        kryo.register(float[].class);
        kryo.register(double[].class);

        kryo.register(RpcInvocation.class);
        kryo.register(Request.class);
        kryo.register(Response.class);

        return kryo;
    }
}
