package com.curioustake.clrs.datastructure;

public class QueueUsingStack<T> {

    private Stack<T> readStack;
    private Stack<T> writeStack;

    public QueueUsingStack(){
        readStack = new Stack<>();
        writeStack = new Stack<>();
    }

    public void enqueue(final T element){
        writeStack.push(element);
    }

    public T dequeue(){
        if(readStack.isEmpty()){
            if(writeStack.isEmpty()){
                return null;
            }

            while(!writeStack.isEmpty()){
                readStack.push(writeStack.pop());
            }
        }

        return readStack.pop();
    }

    public boolean isEmpty() {
        return (readStack.isEmpty() || writeStack.isEmpty());
    }
}
