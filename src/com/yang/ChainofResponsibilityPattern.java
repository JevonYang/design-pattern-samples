package com.yang;

abstract class Politician{

    private Politician superior;

    public Politician getSuperior() {
        return superior;
    }

    public void setSuperior(Politician superior) {
        this.superior = superior;
    }

    abstract void operate(GovPaper govPaper);
}

class GovPaper {
    private String name;
    private int level;

    public GovPaper(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }
}

class President extends Politician{
    private final String name = "President";
    private final int level = 10;

    @Override
    void operate(GovPaper govPaper) {
        if (this.level < govPaper.getLevel()){
            System.out.println(name+" can not decide!");
            getSuperior().operate(govPaper);
        }else {
            System.out.println(name + " publish " + govPaper.getName());
        }
        //System.out.println(name+"published"+govPaper.getName());
    }
}

class VicePresident extends Politician{
    private final String name = "VicePresident";
    private final int level = 9;

    @Override
    void operate(GovPaper govPaper) {
        if (this.level < govPaper.getLevel()){
            System.out.println(name+" can not decide!");
            getSuperior().operate(govPaper);

        }else {
            System.out.println(name + " publish " + govPaper.getName());
        }

    }
}

class Secretary extends Politician{
    private final String name = "Secretary";
    private final int level = 8;


    @Override
    void operate(GovPaper govPaper) {
        if (this.level < govPaper.getLevel()){
            System.out.println(name+" can not decide!");
            getSuperior().operate(govPaper);
        }else {
            System.out.println(this.name + " publish "+govPaper.getName());
        }
    }
}

public class ChainofResponsibilityPattern {
    public static void main(String[] args) {
        President trump = new President();
        VicePresident pence = new VicePresident();
        Secretary tillerson = new Secretary();
        pence.setSuperior(trump);
        tillerson.setSuperior(pence);


        GovPaper Action301 = new GovPaper("301", 0);

        tillerson.operate(Action301);

        GovPaper nuclearWeaponAction = new GovPaper("nuclear action", 10);
        tillerson.operate(nuclearWeaponAction);
    }
}
