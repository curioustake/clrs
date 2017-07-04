package com.curioustake.clrs.datastructure;

public class LinkedList<T extends Comparable> {

    private Node sentinel;

    public LinkedList(){
        sentinel = new Node();
        sentinel.next_ = sentinel;
        sentinel.previous_ = sentinel;
        sentinel.key_ = null;
    }

    public void insert(final T key) {
        Node newNode = new Node();
        newNode.key_ = key;
        sentinel.next_.previous_ = newNode;
        newNode.next_ = sentinel.next_;
        sentinel.next_ = newNode;
        newNode.previous_ = sentinel;
    }

    public boolean search(final T key){
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
