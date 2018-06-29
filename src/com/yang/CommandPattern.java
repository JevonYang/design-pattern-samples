package com.yang;

interface Command{
    public void exe();
}

class Invoker{
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action(){
        command.exe();
    }
}

class Receiver{
    public void action(){
        System.out.println("Command received");
    }
}

class MyCommand implements Command{

    private Receiver receiver;

    public MyCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void exe() {
        receiver.action();
    }
}

public class CommandPattern {

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new MyCommand(receiver);

        Invoker invoker = new Invoker(command);
        invoker.action();
    }
}
