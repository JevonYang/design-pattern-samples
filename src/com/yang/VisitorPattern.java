package com.yang;

import java.util.ArrayList;
import java.util.List;

interface Bill {
    void accept(Viewer viewer);
}

interface Viewer {
    void view(ConsumerBill consumerBill);

    void view(IncomeBill incomeBill);
}

class ConsumerBill implements Bill {

    private String item;
    private double amount;

    public ConsumerBill(String item, double amount) {
        this.item = item;
        this.amount = amount;
    }

    @Override
    public void accept(Viewer viewer) {
        viewer.view(this);
    }

    public String getItem() {
        return item;
    }

    public double getAmount() {
        return amount;
    }
}

class IncomeBill implements Bill {

    private String item;
    private double amount;

    public IncomeBill(String item, double amount) {
        this.item = item;
        this.amount = amount;
    }

    @Override
    public void accept(Viewer viewer) {
        viewer.view(this);
    }

    public String getItem() {
        return item;
    }

    public double getAmount() {
        return amount;
    }

}

class Boss implements Viewer {

    private double totalConsumer;
    private double totalIncome;

    @Override
    public void view(ConsumerBill consumerBill) {
        totalConsumer = totalConsumer + consumerBill.getAmount();
    }

    @Override
    public void view(IncomeBill incomeBill) {
        totalIncome = totalIncome + incomeBill.getAmount();
    }

    public void getTotalConsumer() {
        System.out.println("老板一共消费了" + totalConsumer);
    }

    public void getTotalIncome() {
        System.out.println("老板一共收入了" + totalIncome);
    }
}

class CPA implements Viewer {

    int count = 0;


    @Override
    public void view(ConsumerBill consumerBill) {
        count++;
        if (consumerBill.getItem().equals("消费")) {
            System.out.println("第" + count + "个单子消费了：" + consumerBill.getAmount());
        }
    }

    @Override
    public void view(IncomeBill incomeBill) {

        if (incomeBill.getItem().equals("收入")) {
            System.out.println("第" + count + "个单子收入了：" + incomeBill.getAmount());
        }
    }

}

class AccountBook {

    private List<Bill> listBill = new ArrayList<Bill>();

    public void add(Bill bill) {
        listBill.add(bill);
    }

    public void show(Viewer viewer) {
        for (Bill b : listBill) {
            b.accept(viewer);
        }
    }
}


public class VisitorPattern {

    public static void main(String[] args) {
        AccountBook accountBook = new AccountBook();

        accountBook.add(new ConsumerBill("消费", 100));
        accountBook.add(new ConsumerBill("消费", 999));

        accountBook.add(new IncomeBill("收入",2000));
        accountBook.add(new IncomeBill("收入", 100));



        Boss boss = new Boss();
        boss.view(new ConsumerBill("消费", 100));

        boss.getTotalConsumer();

        accountBook.show(new CPA());


    }

}
