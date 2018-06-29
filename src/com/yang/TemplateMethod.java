package com.yang;

abstract class Template{
    public abstract void featureA();

    public abstract void featureB();

    public void featureC(){
        this.featureA();
        this.featureB();
    }
}

class ProductA extends Template{
    @Override
    public void featureA() {
        System.out.println("this is A product A feature!");
    }

    @Override
    public void featureB() {
        System.out.println("this is A product B feature!");
    }
}

class ProductB extends Template{
    @Override
    public void featureA() {
        System.out.println("this is B product A feature!");
    }

    @Override
    public void featureB() {
        System.out.println("this is B product B feature!");
    }
}

public class TemplateMethod {

    public static void main(String[] args) {
        ProductA productA = new ProductA();
        ProductB productB = new ProductB();

        productA.featureC();
        productB.featureC();
    }
}
