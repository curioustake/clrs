package com.curioustake.clrs.datastructure;

public class SinglyLinkedList<T extends Comparable>{

    private Node head;
    private Node tail;

    public SinglyLinkedList() {
        head = new Node();
        tail = new Node();

        head.next_ = tail;
        tail.next_ = head;
    }

    /////////////////////////////////// STACK INTERFACE ///////////////////////////////////

    public boolean push(T key){
        return addFirst(key);
    }

    public T pop(){
        return removeFirst();
    }

    /////////////////////////////////// QUEUE INTERFACE ///////////////////////////////////

    public boolean enqueue(T key) {
        return addLast(key);
    }

    public T dequeue() {
        return removeFirst();
    }

    public boolean isEmpty(){
        return (head.next_ == tail);
    }

    public boolean insert(final T key){
        return addLast(key);
    }

    public boolean delete(final T key){

        Node nodeBefore = searchNodeBefore(key);

        if(nodeBefore == null)
            return false;

        Node nodeToBeRemoved = nodeBefore.next_;

        if(nodeToBeRemoved.next_ == tail){
            tail.next_ = nodeBefore;
        }

        nodeBefore.next_ = nodeToBeRemoved.next_;

        return true;
    }

    public boolean contains(final T key){
        return searchNodeBefore(key) != null ? true : false;
    }

    public boolean addFirst(final T key){

        Node newNode = new Node();
        newNode.key_ = key;
        newNode.next_ = head.next_;

        if(head.next_ == tail){
            tail.next_ = newNode;
        }

        head.next_ = newNode;

        return true;
    }

    public boolean addLast(final T key){
        Node newNode = new Node();
        newNode.key_ = key;
        newNode.next_ = tail;

        tail.next_.next_ = newNode;

        tail.next_ = newNode;

        return true;
    }

    public T removeFirst(){

        if(head.next_ == tail)
            return null;

        Node nodeToBeRemoved =  head.next_;

        if(nodeToBeRemoved.next_ == tail){
            tail.next_ = head;
        }

        head.next_ = nodeToBeRemoved.next_;

        return nodeToBeRemoved.key_;
    }

    public T removeLast(){

        if(head.next_ == tail)
            return null;

        Node nodeToBeRemoved = tail.next_;
        Node node = head;
        while(node.next_ != nodeToBeRemoved){
            node = node.next_;
        }

        tail.next_ = node;
        node.next_ = tail;

        return nodeToBeRemoved.key_;
    }

    public void reverse(){

        Node current = head;
        Node next = head.next_;

        while(next != tail){
            Node nextNext = next.next_;

            next.next_ = current;

            current = next;
            next = nextNext;
        }

        tail = head;
        head = next;
    }

    private Node searchNodeBefore(T key) {
        Node node = head;

        while (node.next_ != tail) {
            if(node.next_.key_.compareTo(key) == 0){
                return node;
            }
            node = node.next_;
        }

        return null;
    }

    private class Node {
        Node next_;
        T key_;
    }

}
