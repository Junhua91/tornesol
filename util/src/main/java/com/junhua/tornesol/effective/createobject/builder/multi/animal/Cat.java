package com.junhua.tornesol.effective.createobject.builder.multi.animal;

public class Cat extends Animal {

    private final String miao;

    private Cat(Builder builder) {
        super(builder);
        miao = builder.miao;
    }

    public static class Builder extends Animal.Builder<Builder> {
        private String miao;

        public Builder(String food, String action) {
            super(food, action);
        }

        public Builder setMiao(String miao) {
            this.miao = miao;
            return this;
        }

        @Override
        Cat build() {
            return new Cat(this);
        }
    }

    @Override
    protected void doAction() {
        System.out.println("猫喜欢：" + this.getAction());
    }
}
