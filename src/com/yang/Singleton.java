package com.yang;


import java.util.Date;

public class Singleton {
    public static void main(String[] args) {
        HungrySingleton hungrySingleton1 = HungrySingleton.getInstance();
        HungrySingleton hungrySingleton2 = HungrySingleton.getInstance();
        hungrySingleton1.hello();
        hungrySingleton2.hello();

        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstance();
        lazySingleton1.hello();
        lazySingleton2.hello();
    }
}


class HungrySingleton {
    private static HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton(){

    }

    public synchronized static HungrySingleton getInstance(){
        return hungrySingleton;
    }

    public void hello(){
        System.out.println("hello, I'm hungrySingleton"+new Date());
    }
}

class LazySingleton {
    private static LazySingleton singleton = null;

    private LazySingleton(){

    }

    public static LazySingleton getInstance(){
        if (singleton == null){
            synchronized (LazySingleton.class){
                if (singleton == null) {
                    singleton = new LazySingleton();
                }
            }
        }
        return singleton;
    }

    public void hello(){
        System.out.println("hello, I'm LazySingleton"+new Date());
    }
}
