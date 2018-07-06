package com.yang;

import java.util.ArrayList;
import java.util.List;

abstract class Builder{
    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract void buildPartC();

    public abstract Product getProduct();

}

class Director{
    public void Construct(Builder builder){
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
    }
}

class Product{
    private List<String> parts = new ArrayList<>();

    public void add(String part) {
        parts.add(part);
    }

    public void show() {
        for (String item:parts) {
            System.out.println("hello, here is " + item);
        }
    }
}

class ConcreteBuilder extends Builder{

    private Product product = new Product();

    @Override
    public void buildPartA() {
        product.add("partA");
    }

    @Override
    public void buildPartB() {
        product.add("partB");
    }

    @Override
    public void buildPartC() {
        product.add("partC");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}

public class BuilderPattern {
    public static void main(String[] args) {

        Director director = new Director();
        Builder builder=new ConcreteBuilder();

        director.Construct(builder);
        Product product = builder.getProduct();

        product.show();

    }
}
