package com.yang;

interface IProduct{

    public void funcA();

    public void funcB();

}

class MyProduct implements IProduct{

    @Override
    public void funcA() {
        System.out.println("here is my functionA");
    }

    @Override
    public void funcB() {
        System.out.println("here is my functionB");
    }
}

class HisProduct implements IProduct{

    @Override
    public void funcA() {
        System.out.println("here is his functionA");
    }

    @Override
    public void funcB() {
        System.out.println("here is his functionB");
    }
}

class Factory{
    public static IProduct createProduct(Class c){
        IProduct iProduct = null;
        try{
            iProduct = (IProduct)Class.forName(c.getName()).newInstance();
        }catch (Exception e){

        }
        return iProduct;
    }
}

public class FactoryMethod {

    public static void main(String[] args) {
        IProduct myProduct = Factory.createProduct(MyProduct.class);
        myProduct.funcA();

        IProduct hisProduct = Factory.createProduct(HisProduct.class);
        hisProduct.funcB();
    }

}
