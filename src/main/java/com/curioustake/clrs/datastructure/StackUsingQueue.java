package com.curioustake.clrs.datastructure;

public class StackUsingQueue<T> {

    Queue<T> readQueue;
    Queue<T> writeQueue;

    public StackUsingQueue(){
        readQueue = new Queue<>();
        writeQueue = new Queue<>();
    }

    public T push(T element) {
        writeQueue.enqueue(element);

        while(!readQueue.isEmpty()){
            writeQueue.enqueue(readQueue.dequeue());
        }

        Queue<T> temp = readQueue;
        readQueue = writeQueue;
        writeQueue =  temp;

        return readQueue.peek();
    }

    public T pop(){
        return readQueue.dequeue();
    }

    public boolean isEmpty(){
        return readQueue.isEmpty();
    }
}
