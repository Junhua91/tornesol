package com.junhua.tornesol.effective.classandinterface.si;

public class GrapeVending implements IVending {

    VendingDelegator vendingDelegator = new VendingDelegator();

    @Override
    public void start() {
        vendingDelegator.start();
    }

    @Override
    public void process() {
        vendingDelegator.process();
    }

    @Override
    public void stop() {
        vendingDelegator.stop();
    }


    private class VendingDelegator extends AbstractVending {

        @Override
        protected void doProcess() {
            System.out.println("selling grape");
        }
    }
}
