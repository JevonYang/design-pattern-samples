package com.yang;

import java.util.ArrayList;
import java.util.List;

interface IRoot {
    public String getInfo();

    public void add (IBranch iBranch);

    public void add (ILeaf iLeaf);

    public ArrayList getSubordinateInfo();

}

interface IBranch{
    public String getInfo();

    public void add (IBranch iBranch);

    public void add (ILeaf iLeaf);

    public ArrayList getSubordinateInfo();

}

interface ILeaf{
    public String getInfo();
}

@SuppressWarnings("all")
class Root implements IRoot {

    private ArrayList subordinateList = new ArrayList();

    private String name = "";

    private String position = "";

    private int salary = 0;

    public Root(String name, String position, int salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String getInfo() {
        return "Root{" +
                "subordinateList=" + subordinateList +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public void add(IBranch iBranch) {
        this.subordinateList.add(iBranch);

    }

    @Override
    public void add(ILeaf iLeaf) {
        this.subordinateList.add(iLeaf);

    }

    @Override
    public ArrayList getSubordinateInfo() {
        return this.subordinateList;
    }
}

@SuppressWarnings("all")
class Branch implements IBranch {

    private ArrayList subordinateList = new ArrayList();

    private String name = "";

    private String position = "";

    private int salary = 0;

    public Branch(String name, String position, int salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String getInfo() {
        return "Root{" +
                "subordinateList=" + subordinateList +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public void add(IBranch iBranch) {
        this.subordinateList.add(iBranch);

    }

    @Override
    public void add(ILeaf iLeaf) {
        this.subordinateList.add(iLeaf);

    }

    @Override
    public ArrayList getSubordinateInfo() {
        return this.subordinateList;
    }
}

class Leaf implements ILeaf {

    private String name = "";
    private String position = "";
    private int salary = 0;

    public Leaf(String name, String position, int salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String getInfo() {
        return "Leaf{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}




public class CompositePattern {

    private static void getAllSubordinateInfo(ArrayList subordinateList){
        int length = subordinateList.size();
        for(int m=0;m<length;m++){
            Object s = subordinateList.get(m);
            if(s instanceof Leaf){
                ILeaf employee = (ILeaf)s;
                System.out.println(((Leaf) s).getInfo());
            }else{
                IBranch branch = (IBranch)s;
                System.out.println(branch.getInfo());
                getAllSubordinateInfo(branch.getSubordinateInfo());
            }
        }
    }


    public static void main(String[] args) {

        IRoot ceo = new Root("jack", "president", 100000);
        IBranch cto = new Branch("body1", "cto", 1000000);
        IBranch cfo = new Branch("body2", "cfo", 100000);

        ILeaf a = new Leaf("a", "developer", 10000);
        ILeaf b = new Leaf("b", "developer", 1000000);
        ILeaf c = new Leaf("c", "Account", 10000000);
        ILeaf d = new Leaf("d", "secretary", 100000);
        ceo.add(cto);
        ceo.add(cfo);
        ceo.add(d);

        cto.add(a);
        cto.add(b);

        cfo.add(c);

        ceo.getSubordinateInfo();

        getAllSubordinateInfo(ceo.getSubordinateInfo());

    }
}
