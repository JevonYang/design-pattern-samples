package com.yang;

interface IProxy{

    public void functionA();

    public void functionB();

}

class Client implements IProxy{
    @Override
    public void functionA() {
        System.out.println("here is what client needA");
    }

    @Override
    public void functionB() {
        System.out.println("here is what client needsB");
    }
}

class MyProxy implements IProxy{

    private IProxy iProxy;

    public MyProxy() {
        this.iProxy = new Client();
    }

    public MyProxy(IProxy iProxy) {
        this.iProxy = iProxy;
    }

    @Override
    public void functionA() {
        this.iProxy.functionA();
    }

    @Override
    public void functionB() {
        this.iProxy.functionB();
    }
}

public class Proxy {

    public static void main(String[] args) {
        MyProxy myProxy = new MyProxy();
        myProxy.functionA();
    }

}
