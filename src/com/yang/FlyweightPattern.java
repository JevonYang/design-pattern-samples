package com.yang;

import java.util.Hashtable;

class CharactorFactory {
    private Hashtable<String, Flyweight> charactors = new Hashtable<>();

    public CharactorFactory() {
        charactors.put("A", new FlyweightImpA());
        charactors.put("B", new FlyweightImpB());
    }

    public Flyweight getCharactor(String key) {
        Flyweight charactor = (Flyweight) charactors.get(key);
        if (charactor == null) {
            if (key.equals("A")) {
                charactor = new FlyweightImpA();
            } else if (key.equals("B")) {
                charactor = new FlyweightImpB();
            }
            charactors.put(key, charactor);
        }
        return charactor;
    }
}

abstract class Flyweight {
    protected String charStr = "";
    protected int fontSize;

    protected abstract void operate(int fontSize);

    protected abstract void displayChar();
}

class FlyweightImpA extends Flyweight {

    public FlyweightImpA() {
        this.charStr = "A";
        this.fontSize = 12;
    }

    @Override
    protected void operate(int fontSize) {
        this.fontSize = fontSize;
    }

    @Override
    protected void displayChar() {
        System.out.println("Char: "+this.charStr+" FontSize: "+this.fontSize);
    }
}

class FlyweightImpB extends Flyweight {

    public FlyweightImpB() {
        this.charStr = "B";
        this.fontSize = 12;
    }

    @Override
    protected void operate(int fontSize) {
        this.fontSize = fontSize;
    }

    @Override
    protected void displayChar() {
        System.out.println("Char: "+this.charStr+" FontSize: "+this.fontSize);
    }
}


public class FlyweightPattern {
    public static void main(String[] args) {
        CharactorFactory factory = new CharactorFactory();
        Flyweight A = factory.getCharactor("A");
        Flyweight copyA = factory.getCharactor("A");
        Flyweight B = factory.getCharactor("B");
        A.displayChar();
        B.displayChar();
        System.out.println("A == copyA ?");
        System.out.println(A == copyA);

    }

}
