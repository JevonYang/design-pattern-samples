package com.yang;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    public void update(String message);
}

interface Observerable{

    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();
}

class Speaker implements Observerable {

    private List<Observer> list;
    private String message;

    public Speaker() {
        list = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if(!list.isEmpty()) {
            list.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        for(int i = 0; i < list.size(); i++) {
            Observer observer = list.get(i);
            observer.update(message);
        }
    }

    public void setInfomation(String s) {
        this.message = s;
        System.out.println("Update Information： " + s);
        notifyObserver();
    }

}

class User implements Observer {

    private String name;
    private String message;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        read();
    }

    public void read() {
        System.out.println(name + " getInfo： " + message);
    }
}



public class ObserverPattern {

    public static void main(String[] args) {

        Speaker server = new Speaker();
        Observer trump = new User("trump");

        server.registerObserver(trump);
        server.setInfomation("hello, trump");

        Observer lisa = new User("lisa");
        server.registerObserver(lisa);
        server.setInfomation("hello, everyone");

    }
}
