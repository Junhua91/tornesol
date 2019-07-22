package com.junhua.tornesol.effective.classandinterface.si;

public abstract class AbstractVending implements IVending {

    @Override
    public void start() {
        System.out.println("start vending");

    }

    protected abstract void doProcess();

    @Override
    public void process() {
        System.out.println("========");
        doProcess();
        System.out.println("========");
    }

    @Override
    public void stop() {
        System.out.println("stop vending");
    }
}
