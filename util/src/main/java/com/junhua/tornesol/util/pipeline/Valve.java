package com.junhua.tornesol.util.pipeline;

public interface Valve {

    Valve getNext();

    void setNext(Valve valve);

    void backgroundProcess();

    void invoke(Request request, Response response);
}
