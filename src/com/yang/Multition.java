package com.yang;

import java.util.ArrayList;
import java.util.Random;

class MyMultition{
    private static int maxOfInstance = 2;

    private static ArrayList infoList = new ArrayList(maxOfInstance);

    private static ArrayList multitionList = new ArrayList(maxOfInstance);

    private static int count = 0;

    static {
        for (int i = 0; i < maxOfInstance; i++) {
            multitionList.add(new MyMultition("instance"+ i));
        }
    }

    public MyMultition() {

    }

    public MyMultition(String info) {
        infoList.add(info);
    }

    public static MyMultition getInstance(){
        Random random = new Random();
        count = random.nextInt(maxOfInstance);
        return (MyMultition)multitionList.get(count);
    }

    public static void info(){
        System.out.println(multitionList.get(count));
    }
}

public class Multition {

    public static void main(String[] args) {
        MyMultition myMultition1= new MyMultition();
        MyMultition myMultition2= new MyMultition();

        myMultition1.info();
        myMultition2.info();

    }

}


