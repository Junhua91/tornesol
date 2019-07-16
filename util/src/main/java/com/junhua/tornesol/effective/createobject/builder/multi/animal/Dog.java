package com.junhua.tornesol.effective.createobject.builder.multi.animal;

public class Dog extends Animal {

    private final String wang;

    public static class Builder extends Animal.Builder<Builder> {
        private String wang;

        public Builder(String food, String action) {
            super(food, action);
        }

        public Builder setWang(String wang) {
            this.wang = wang;
            return this;
        }

        @Override
        Dog build() {
            return new Dog(this);
        }
    }

    private Dog(Builder builder) {
        super(builder);
        this.wang = builder.wang;
    }

    @Override
    protected void doAction() {
        System.out.println("狗喜欢：" + this.getAction());
    }
}
