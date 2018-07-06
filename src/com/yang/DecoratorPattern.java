package com.yang;

interface ICar{
    public void move();
}

class Car implements ICar{

    @Override
    public void move() {
        System.out.println("路上跑");
    }
}

class SuperCar extends Car{

    private ICar car;

    public SuperCar(ICar car) {
        this.car = car;
    }

    @Override
    public void move() {
        car.move();
    }
}

class FlyCar extends SuperCar{

    public FlyCar(ICar car) {
        super(car);
    }

    public void fly(){
        System.out.println("flying.....");
    }

    @Override
    public void move() {
        super.move();
        this.fly();
    }
}

class SwinCar extends SuperCar{
    public SwinCar(ICar car) {
        super(car);
    }

    public void swim() {
        System.out.println("swimming....");
    }

    @Override
    public void move() {
        super.move();
        this.swim();
    }
}



public class DecoratorPattern {
    public static void main(String[] args) {

        Car car = new Car();
        //car.move();

//        FlyCar flyCar= new FlyCar(car);
//        flyCar.move();

        SwinCar swinCar = new SwinCar(new FlyCar(car));
        swinCar.move();


    }
}
