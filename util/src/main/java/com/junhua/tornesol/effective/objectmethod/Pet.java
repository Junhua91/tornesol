package com.junhua.tornesol.effective.objectmethod;

public class Pet implements Cloneable {

    private String name;
    private String type;

    private int hashCode;

    public Pet(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = 31 * result + name.hashCode();
            result = 31 * result + type.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Pet)) return false;
        Pet pet = (Pet) obj;
        return pet.type.equals(this.type)
                && pet.name.equals(this.name);
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }


}
