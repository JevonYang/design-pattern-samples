package com.yang;

interface Process{
    public void step1();

    public void step2();

    public void step3();
}

class ProcessImp implements Process{
    @Override
    public void step1() {
        System.out.println("hello, here is step 1");
    }

    @Override
    public void step2() {
        System.out.println("hello, here is step 2");
    }

    @Override
    public void step3() {
        System.out.println("hello, here is step 3");
    }
}

class MyFacade{
    private Process process;

    public MyFacade(Process process) {
        this.process = process;
    }

    public void myProcess(){
        this.process.step1();
        this.process.step2();
        this.process.step3();
    }


}

public class Facade {

    public static void main(String[] args) {
        Process process = new ProcessImp();
        MyFacade myFacade = new MyFacade(process);
        myFacade.myProcess();
    }

}
