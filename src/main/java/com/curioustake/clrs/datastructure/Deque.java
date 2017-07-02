package com.curioustake.clrs.datastructure;

public class Deque<T> {

    private Stack<T> headStack;
    private Queue<T> tailQueue;

    public Deque(){
        headStack = new Stack<>();
        tailQueue = new Queue<>();
    }

    ///////////////////////// STACK INTERFACE ////////////////////////////////////////
    public T push(T element) {
        return headStack.push(element);
    }

    public T pop() {
        return headStack.isEmpty() ? tailQueue.dequeue() : headStack.pop() ;
    }
    //////////////////////////////////////////////////////////////////////////////////

    ///////////////////////// QUEUE INTERFACE ////////////////////////////////////////
    public T enqueue(T element){
        return tailQueue.enqueue(element);
    }

    public T dequeue(){
        return headStack.isEmpty() ? tailQueue.dequeue() : headStack.pop() ;
    }
    //////////////////////////////////////////////////////////////////////////////////

    public boolean isEmpty(){
        return headStack.isEmpty() && tailQueue.isEmpty();
    }

}
