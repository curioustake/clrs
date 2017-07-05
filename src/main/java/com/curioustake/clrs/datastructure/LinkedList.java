package com.curioustake.clrs.datastructure;

public class LinkedList<T extends Comparable> {

    private Node sentinel;

    public LinkedList(){
        sentinel = new Node();
        sentinel.next_ = sentinel;
        sentinel.previous_ = sentinel;
        sentinel.key_ = null;
    }

    public boolean insert(final T key) {
        return addLast(key);
    }

    public boolean addFirst(final T key) {
        Node newNode = new Node();
        newNode.key_= key;
        newNode.next_ = sentinel.next_;
        newNode.previous_ = sentinel;
        sentinel.next_.previous_ = newNode;
        sentinel.next_ = newNode;
        return true;
    }

    public boolean addLast(final T key){
        Node newNode = new Node();
        newNode.key_ = key;
        newNode.next_ = sentinel;
        newNode.previous_ = sentinel.previous_;
        sentinel.previous_.next_ = newNode;
        sentinel.previous_ = newNode;
        return true;
    }

    public boolean contains(final T key){
        Node node = searchNode(key);

        if(node == null){
            return false;
        }

        return true;
    }

    public boolean delete(final T key) {
        Node node = searchNode(key);

        if(node == null){
            return false;
        }

        node.previous_.next_ = node.next_;
        node.next_.previous_ = node.previous_;

        return true;
    }

    public T removeFirst(){
        if(sentinel.next_ == sentinel)
            return null;

        return remove(sentinel.next_);

    }

    public T removelast(){
        if(sentinel.next_ == sentinel)
            return null;
        return remove(sentinel.previous_);
    }


    private T remove(Node nodeToRemove) {
        nodeToRemove.previous_.next_ = nodeToRemove.next_;
        nodeToRemove.next_.previous_ = nodeToRemove.previous_;
        return nodeToRemove.key_;
    }

    private Node searchNode(final T key){

        Node currentNode = sentinel.next_;
        while(currentNode != sentinel) {

            if(currentNode.key_.compareTo(key) == 0)
                return currentNode;

            currentNode = currentNode.next_;
        }
        return null;
    }

    class Node{
        Node next_;
        Node previous_;
        T key_;
    }
}
