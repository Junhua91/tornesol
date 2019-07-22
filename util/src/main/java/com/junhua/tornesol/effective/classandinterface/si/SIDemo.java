package com.junhua.tornesol.effective.classandinterface.si;


/**
 * 1. SI 模式既有Abstract 能减少重复代码的优点，也有interface能实现多继承的优点
 * <p>
 * 2. SI 实现步骤
 * ## a). 创建一个接口
 * ## b). 创建抽象类继承接口，实现一些公用的方法
 * ## c). 在每个实现类里面，创建一个私有的内部类继承抽象类
 */
public class SIDemo {

    public static void main(String[] args) {
        AppleVending appleVending = new AppleVending();
        appleVending.start();
        appleVending.process();
        appleVending.stop();

        GrapeVending grapeVending = new GrapeVending();
        grapeVending.start();
        grapeVending.process();
        grapeVending.stop();

    }
}
