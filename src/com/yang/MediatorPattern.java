package com.yang;

abstract class Colleague {
    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void operate();
}

class ConcreteColleagueA extends Colleague{

    public void notifyColleagueB() {
        mediator.notifyColleagueB();
    }

    @Override
    public void operate() {
        System.out.println("This is colleague a operate!");
    }
}

class ConcreteColleagueB extends Colleague{

    public void notifyColleagueA() {
        mediator.notifyColleagueA();
    }

    @Override
    public void operate() {
        System.out.println("This is colleague b operate!");
    }
}

abstract class Mediator {
    protected Colleague colleagueA;
    protected Colleague colleagueB;

    public Mediator(Colleague colleagueA, Colleague colleagueB) {
        this.colleagueA = colleagueA;
        this.colleagueB = colleagueB;
    }

    abstract void notifyColleagueA();
    abstract void notifyColleagueB();
}

class ConcreteMediator extends Mediator {

    public ConcreteMediator(Colleague colleagueA, Colleague colleagueB) {
        super(colleagueA, colleagueB);
    }

    @Override
    void notifyColleagueA() {
        if (colleagueA!= null) {
            System.out.println("notify A ....");
            colleagueB.operate();
        }
    }

    @Override
    void notifyColleagueB() {
        if (colleagueA != null) {
            System.out.println("notify B ....");
            colleagueA.operate();
        }

    }
}

public class MediatorPattern {
    public static void main(String[] args) {

        Colleague colleagueA = new ConcreteColleagueA();
        Colleague colleagueB = new ConcreteColleagueB();

        Mediator mediator = new ConcreteMediator(colleagueA, colleagueB);
        colleagueA.setMediator(mediator);
        colleagueB.setMediator(mediator);

        ((ConcreteColleagueA) colleagueA).notifyColleagueB();
        ((ConcreteColleagueB) colleagueB).notifyColleagueA();

    }
}
