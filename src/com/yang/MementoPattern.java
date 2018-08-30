package com.yang;

class Originator implements Cloneable {

    private int healthy;
    private int defence;
    private int attack;

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void birth() {
        this.setHealthy(100);
        this.setDefence(100);
        this.setAttack(100);
        showState();
    }

    public void fight() {
        this.setAttack(10);
        this.setDefence(10);
        this.setHealthy(10);
        showState();
    }

    public Memento saveStates() {
        try{
            Originator record = (Originator) this.clone();
            return new Memento(record);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setMemento(Memento memento) {
        this.setDefence(memento.getDefence());
        this.setHealthy(memento.getHealthy());
        this.setAttack(memento.getAttack());
    }

    public void showState() {
        System.out.println("Healthy: "+this.healthy+ " Attack: "+ this.attack+" Defence: "+this.defence);
    }
}

class Memento {
    private int healthy;
    private int defence;
    private int attack;

    public Memento(Originator originator) {
        this.setAttack(originator.getAttack());
        this.setDefence(originator.getDefence());
        this.setHealthy(originator.getHealthy());
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}

class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}

public class MementoPattern {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.birth();
        caretaker.setMemento(originator.saveStates());
        originator.fight();
        originator.setMemento(caretaker.getMemento());
        originator.showState();
    }
}
