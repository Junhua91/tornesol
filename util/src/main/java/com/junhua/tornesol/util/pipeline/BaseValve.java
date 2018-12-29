package com.junhua.tornesol.util.pipeline;

public abstract class BaseValve implements Valve {

    protected Valve next = null;

    @Override
    public Valve getNext() {
        return next;
    }

    @Override
    public void setNext(Valve next) {
        this.next = next;
    }

    @Override
    public void backgroundProcess() {
        //todo process here
    }
}
