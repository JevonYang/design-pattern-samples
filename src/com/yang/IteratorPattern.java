package com.yang;

import java.util.ArrayList;
import java.util.List;

interface MyIterator{
    void first();//将游标指向第一个元素
    void next();//将游标指向下一个元素
    boolean hasNext();//判断是否有下一个元素

    boolean isFirst();//判断是否是第一个元素
    boolean isLast();//判断是否是最后一个元素
    Object getCurrentObj();//获取当前对象
}

class MyAggregate{

    private List<Object> list = new ArrayList<>();

    public void add(Object item){
        this.list.add(item);
    }

    public void removeObject(Object item){
        this.list.remove(item);
    }

    public List<Object> getList(){
        return list;
    }

    public MyIterator createIterator(){
        return new ConcreteIterator();
    }

    private class ConcreteIterator implements MyIterator{

        private int cursor;

        @Override
        public void first() {
            cursor=0;
        }

        @Override
        public void next() {
            if (cursor<list.size()){
                cursor++;
            }
        }

        @Override
        public boolean hasNext() {
            if (cursor<list.size()){
                return true;
            }
            return false;
        }

        @Override
        public boolean isFirst() {
            return cursor == 0;
        }

        @Override
        public boolean isLast() {
            return cursor == list.size() - 1;
        }

        @Override
        public Object getCurrentObj() {
            return list.get(cursor);
        }
    }

}

/*
*
* 迭代器模式仅做示例，jdk中有实现的Iterator
*
*/

public class IteratorPattern {
    public static void main(String[] args) {
        MyAggregate aggregate = new MyAggregate();

        aggregate.add("1111");
        aggregate.add("2222");
        aggregate.add("3333");
        aggregate.add("4444");

        MyIterator iterator = aggregate.createIterator();

        while (iterator.hasNext()){
            System.out.println(iterator.getCurrentObj());
            iterator.next();
        }
    }
}
