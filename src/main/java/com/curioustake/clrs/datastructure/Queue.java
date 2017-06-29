package com.curioustake.clrs.datastructure;

import java.util.Arrays;

public class Queue<T> {

    private Object[] elements;

    private static final int INITIAL_SIZE = 10;
    private static final int SCALING_FACTOR = 2;

    private int head;
    private int tail;


    public Queue(){
        elements = new Object[INITIAL_SIZE];
        head = 0;
        tail = 0;
    }

    public T enqueue(final T element){
        elements[tail] = element;
        T returnElement = (T)elements[tail];
        tail = nextTail();
        return returnElement;
    }

    public T dequeue(){
        if(head == tail){
            return null;
        }

        T returnElement = (T)elements[head];

        head = nextHead();

        return returnElement;
    }

    public T peek(){
        if(head == tail){
            return null;
        }

        return (T)elements[head];
    }

    public boolean isEmpty(){
        return head == tail;
    }

    private int nextHead(){
        if(head < tail) {
            return head+1;
        } else {
            if((head+1) < elements.length) {
                return head + 1;
            } else {
                return 0;
            }
        }
    }

    private int nextTail() {
        if(tail >= head) {
            if((tail+1) < elements.length){
                return tail + 1;
            } else {
                if(head > 0){
                    return 0;
                } else {
                    grow();
                    return tail + 1;
                }
            }
        } else {
            if((tail+1) >= head) {
                grow();
            }
            return  tail + 1;
        }
    }

    private void grow(){
        int oldSize = elements.length;
        int newSize =  oldSize * SCALING_FACTOR;
        elements = Arrays.copyOf(elements, newSize);

        if(tail < head){
            for(int i=0; i<head; i++){
                tail = oldSize+i;
                elements[tail] = elements[i];
            }
        }
    }
}