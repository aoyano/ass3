package com.company;
import java.util.*;

public class MyStack<T extends Comparable<T>> {
    private ArrayList<T> arrayList;

    public MyStack() {
        arrayList = new ArrayList<T>();
    }

    public int size() {
        return arrayList.size();
    }

    public boolean isEmpty() {
        return arrayList.size() == 0;
    }

    public T push(T item){
        arrayList.add(item);
        return item;
    }

    public T pop(){
        if (arrayList.size() == 0){
            System.out.println("Warning");
            return null;
        }
        T item = peek();
        arrayList.remove(size() - 1);
        return item;
    }

    public T peek(){
        if (arrayList.size() == 0){
            System.out.println("Warning");
            return null;
        }
        return arrayList.get(size() - 1);
    }
}
