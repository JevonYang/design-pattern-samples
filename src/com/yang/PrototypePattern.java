package com.yang;

class Prototype implements Cloneable {

    private String name;

    private String someProperty;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSomeProperty() {
        return someProperty;
    }

    public void setSomeProperty(String someProperty) {
        this.someProperty = someProperty;
    }

    public Prototype(String name, String someProperty) {
        this.name = name;
        this.someProperty = someProperty;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Prototype prototype = null;
        prototype = (Prototype) super.clone();
        return prototype;
    }
}

public class PrototypePattern {

    public static void main(String[] args) {
        Prototype prototype = new Prototype("example", "props");

        try{
            Prototype copy = (Prototype) prototype.clone();

            System.out.println("prototype == copy ? ");
            System.out.println(prototype==copy);

            System.out.println("prototype class == copy class?");
            System.out.println(prototype.getClass()== copy.getClass());
        }catch (Exception e) {

        }


    }
}
