package com.junhua.rpc.transport.support;


import com.junhua.rpc.common.DRpcException;
import com.junhua.rpc.transport.model.Request;
import com.junhua.rpc.transport.model.Response;
import io.netty.channel.Channel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用于关联Request、Response、Channel；异步处理
 */
public class DefaultFuture implements ResponseFuture {

    private Response response;
    private final Request request;

    private static final Map<Long, Channel> CHANNELS = new ConcurrentHashMap<>();
    private static final Map<Long, DefaultFuture> FUTURES = new ConcurrentHashMap<>();
    private final Lock lock = new ReentrantLock();
    private final Condition done = lock.newCondition();
    private final int timeout;
    private final long id;


    public DefaultFuture(Request request, Channel channel, int timeout) {
        this.request = request;
        this.timeout = timeout;
        this.id = request.getId();
        CHANNELS.put(request.getId(), channel);
        FUTURES.put(request.getId(), this);
    }

    @Override
    public Response get() throws DRpcException {
        return null;
    }

    @Override
    public Response get(int timeoutInMillis) throws DRpcException {
        return null;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    public void cancel() {
        Response errorResult = new Response(id);
        response = errorResult;
        FUTURES.remove(id);
        CHANNELS.remove(id);
    }

    public static void received(Channel channel, Response response) {
        try {
            DefaultFuture future = FUTURES.remove(response.getId());
            if (future != null) {
                future.doReceived(response);
            }
        } finally {
            CHANNELS.remove(response.getId());
        }
    }

    private void doReceived(Response res) {
        lock.lock();
        try {
            response = res;
            done.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
