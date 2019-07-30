package com.junhua.tornesol.effective.jdk.base;

/**
 * Java always passes arguments by value NOT by reference.
 */
public class PassByValue {

    static private class Dog {
        private String name;

        public Dog(String name) {
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
        }

        String getObjectAddress() {
            return super.toString();
        }
    }

    public static void changeName1(Dog dog) {
        Dog coco = dog;
        System.out.println(coco.getObjectAddress());
        //创建了新的对象
        coco = new Dog("coco");
        System.out.println(coco.getObjectAddress());

    }

    public static void changeName2(Dog dog) {
        dog.setName("rooster");
    }

    public static void main(String[] args) {
        Dog max = new Dog("max");
        System.out.println(max.getObjectAddress());
        changeName1(max);
        System.out.println(max.getObjectAddress());


        System.out.println("*************");
        System.out.println(max.name);
        changeName2(max);
        System.out.println(max.name);
    }
}
