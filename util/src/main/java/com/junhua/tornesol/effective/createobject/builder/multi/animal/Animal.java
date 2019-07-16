package com.junhua.tornesol.effective.createobject.builder.multi.animal;

public abstract class Animal {

    private final String food;
    private final String action;

    public static abstract class Builder<T extends Builder<T>> {
        private final String food;
        private final String action;

        public Builder(String food, String action) {
            this.food = food;
            this.action = action;
        }

        abstract Animal build();
    }

    Animal(Builder<?> builder) {
        food = builder.food;
        action = builder.action;
    }

    abstract protected void doAction();

    public String getAction() {
        return action;
    }
}
