package com.yang;


abstract class LiftState {

    protected MyContext myContext;

    public void setContext(MyContext myContext) {
        this.myContext = myContext;
    }

    public abstract void open();

    public abstract void close();

    public abstract void run();

    public abstract void stop();

}

class OpenningState extends LiftState{

    @Override
    public void open() {
        System.out.println("Lift is openning!......");
    }

    @Override
    public void close() {
        super.myContext.setLiftState(MyContext.closingState);
        super.myContext.getLiftState().close();
    }

    @Override
    public void run() {

    }

    @Override
    public void stop() {

    }
}

class ClosingState extends LiftState {

    @Override
    public void open() {
        super.myContext.setLiftState(MyContext.openningState);
        super.myContext.getLiftState().open();
    }

    @Override
    public void close() {
        System.out.println("Lift is closing up!.....");
    }

    @Override
    public void run() {
        super.myContext.setLiftState(MyContext.runningState);
        super.myContext.getLiftState().run();
    }

    @Override
    public void stop() {
        super.myContext.setLiftState(MyContext.stoppingState);
        super.myContext.getLiftState().close();
    }
}

class RunningState extends LiftState {

    @Override
    public void open() {

    }

    @Override
    public void close() {

    }

    @Override
    public void run() {
        System.out.println("Lift is running!....");
    }

    @Override
    public void stop() {
        super.myContext.setLiftState(MyContext.stoppingState);
        super.myContext.getLiftState().stop();
    }
}

class StoppingState extends LiftState {

    @Override
    public void open() {
        super.myContext.setLiftState(MyContext.openningState);
        super.myContext.getLiftState().open();
    }

    @Override
    public void close() {
        super.myContext.setLiftState(MyContext.closingState);
        super.myContext.getLiftState().close();
    }

    @Override
    public void run() {
        super.myContext.setLiftState(MyContext.runningState);
        super.myContext.getLiftState().run();
    }

    @Override
    public void stop() {
        System.out.println("Lift is stopping!...");
    }
}

class MyContext {
    public final static OpenningState openningState = new OpenningState();
    public final static ClosingState closingState = new ClosingState();
    public final static RunningState runningState = new RunningState();
    public final static StoppingState stoppingState = new StoppingState();

    private LiftState liftState;

    public LiftState getLiftState() {
        return liftState;
    }

    public void setLiftState(LiftState liftState) {
        this.liftState = liftState;
        this.liftState.setContext(this);
    }

    public void open() {
        this.liftState.open();
    }

    public void close() {
        this.liftState.close();
    }

    public void run() {
        this.liftState.run();
    }

    public void stop() {
        this.liftState.stop();
    }

}


public class StatePattern {

    public static void main(String[] args) {
        MyContext myContext = new MyContext();
        myContext.setLiftState(new ClosingState());
        myContext.run();
        myContext.open();  // this state does not work
        myContext.stop();
        myContext.open();

    }
}
