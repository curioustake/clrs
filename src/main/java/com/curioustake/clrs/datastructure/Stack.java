package com.curioustake.clrs.datastructure;

import java.util.Arrays;

public class Stack<T> {

    private Object elements[];
    private int top;

    private static final int INITIAL_STACK_SIZE = 10;
    private static final int GROWTH_FACTOR = 2;

    public Stack() {
        elements = new Object[INITIAL_STACK_SIZE];
        top = -1;
    }

    public T push(T element) {
        if((top+1) >= elements.length){
            grow();
        }
        elements[++top] = element;
        return (T) elements[top];
    }

    public T pop(){
        if(top<0)
            return null;

        --top;
        return (T)elements[(top+1)];
    }

    public int size(){
        return top+1;
    }

    public boolean isEmpty(){
        return (top+1) <= 0;
    }

    private void grow() {
        int newSize = elements.length * GROWTH_FACTOR;
        elements = Arrays.copyOf(elements, newSize);
    }

}
