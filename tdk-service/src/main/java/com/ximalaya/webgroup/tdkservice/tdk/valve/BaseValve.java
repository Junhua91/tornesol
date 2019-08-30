package com.ximalaya.webgroup.tdkservice.tdk.valve;

public abstract class BaseValve implements Valve {

    private Valve next;

    @Override
    public Valve getNext() {
        return next;
    }

    @Override
    public void setNext(Valve next) {
        this.next = next;
    }
}
