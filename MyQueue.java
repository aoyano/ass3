package com.company;

import java.util.*;

public class MyQueue<T extends Comparable<T>> {
    private LinkedList<T> linkedList;

    public MyQueue() {
        linkedList = new LinkedList<T>();
    }

    public int size() {
        return linkedList.size();
    }

    public boolean isEmpty() {
        return linkedList.size() == 0;
    }

    public T enqueue(T item){
        linkedList.add(item);
        return item;
    }

    public T dequeue(){
        if (linkedList.size() == 0){
            System.out.println("Warning");
            return null;
        }
        T item = peek();
        int first = 0;
        linkedList.remove(first);
        return item;
    }

    public T peek(){
        if (linkedList.size() == 0){
            System.out.println("Warning");
            return null;
        }
        return linkedList.get(size() - 1);
    }
}

