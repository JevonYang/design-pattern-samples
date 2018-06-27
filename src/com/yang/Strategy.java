package com.yang;

interface IStrategy {
    public void functionX();
}

class MyStrategy implements IStrategy {

    @Override
    public void functionX() {
        System.out.println("hello, there is a strategy here");
    }
}

class Context {
    private IStrategy iStrategy;

    public Context(IStrategy iStrategy) {
        this.iStrategy = iStrategy;
    }

    public void functionX() {
        this.iStrategy.functionX();
    }

}


public class Strategy {

    public static void main(String[] args) {
        Context context = new Context(new MyStrategy());
        context.functionX();

    }
}
