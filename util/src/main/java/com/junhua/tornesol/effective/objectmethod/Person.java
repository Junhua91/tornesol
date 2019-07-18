package com.junhua.tornesol.effective.objectmethod;

public class Person implements Cloneable {

    private int age;
    private String name;
    private Pet pet;

    private int hashCode;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Person)) return false;
        Person person = (Person) obj;
        return person.age == this.age &&
                person.name.equals(this.name);
    }

    /**
     * 1. guava 的方式生成hashCode
     *
     * @return
     */
//    @Override
//    public int hashCode() {
//        Funnel<Person> funnel = new Funnel<Person>() {
//            @Override
//            public void funnel(Person from, PrimitiveSink into) {
//                into.putInt(from.age)
//                        .putString(from.name, Charsets.UTF_8);
//            }
//        };
//        HashFunction hf = Hashing.md5();
//        HashCode hashCode = hf.newHasher().putObject(this, funnel).hash();
//        return hashCode.asInt();
//    }

    /**
     * 2. Objects.hashCode:performance is not critical
     *
     * @return
     */
//    @Override
//    public int hashCode() {
//        return Objects.hash(age, name);
//    }


    /**
     * 3. 自定义hash
     *
     * @return
     */
    @Override
    public int hashCode() {
        //#1. 如果是属性是primitive type：Type.hashCode(f)
        //#2. 如果属性是一个object的引用，生成这个对象的hash
        //#3. 如果属性是一个数组，遍历数组元素，生成hashCode；也可以使用Arrays.hashCode
        //#4. 组合所有的hashCode：result = 31 * result + c;
        //缓存对象的hashCode，避免每次比较都要计算
        int result = hashCode;
        if (result == 0) {
            result = Integer.hashCode(age);
            //31是奇数,偶数会导致乘法溢出；31 = 2^5 - 1,乘法运算可以优化成位运算；32的hash冲突概率跟高
            result = 31 * result + name.hashCode();
            hashCode = result;
        }
        return result;
    }

    /**
     * 深拷贝：为每一个reference 重新创建新的对象
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();
        Pet pet = ((Person) obj).getPet();
        if (pet != null) ((Person) obj).setPet((Pet) pet.clone());
        return obj;
    }


    /**
     * 浅拷贝：依然是赋值
     *
     * @return
     * @throws CloneNotSupportedException
     */
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
