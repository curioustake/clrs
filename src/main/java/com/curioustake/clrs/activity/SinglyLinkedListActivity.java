package com.curioustake.clrs.activity;

import com.curioustake.clrs.datastructure.*;
import com.curioustake.clrs.utils.ListHelper;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SinglyLinkedListActivity implements Activity{

    @Override
    public void invoke(String[] args) {
        System.out.println( "Execute => " + Arrays.toString(args) );

        final int count = Integer.parseInt(args[1]);
        final int max = Integer.parseInt(args[2]);

        List<Integer> randomList = ListHelper.getRandomList(count, max);
        //ListHelper.printList("Original : ", randomList);

        testSinglyLinkedList(randomList);

        testStackInterface(randomList);

        testQueueInterface(randomList);

        testReverse(randomList);

    }

    private void testSinglyLinkedList(List<Integer> randomList) {
        SinglyLinkedList<Integer> l1 = new SinglyLinkedList<>();
        LinkedList l2 = new LinkedList();

        Random random = new Random();

        for(Integer i :  randomList){

            int randomOperation = random.nextInt(3);

            switch (randomOperation){
                case 0:
                    l1.insert(i);
                    l2.add(i);
                    break;
                case 1:

                    if(!l2.isEmpty()){
                        boolean b1 = l1.contains(i);
                        boolean b2 = l2.contains(i);

                        //System.out.println("Search result for (" + i + ") : " + b1 + "|" + b2);

                        if( b1 ^ b2 ) {
                            System.out.println("Inconsistent contains result");
                            throw new RuntimeException("Inconsistent contains result");
                        }
                    }

                    l1.insert(i);
                    l2.add(i);
                    break;
                case 2:

                    if(!l2.isEmpty()){
                        boolean b1 = l1.delete(i);
                        boolean b2 = l2.remove(i);

                        //System.out.println("Delete result for (" + i + ") : " + b1 + "|" + b2);

                        if( b1 ^ b2 ) {
                            System.out.println("Inconsistent delete result");
                            throw new RuntimeException("Inconsistent delete result");
                        }
                    }

                    l1.insert(i);
                    l2.add(i);
                    break;
                default:
                    System.out.println("Incorrect Operation for a LinkedList");
                    throw new RuntimeException("Incorrect Operation for a LinkedList");
            }
        }

        System.out.println("Size : " + l2.size());

        while (!l2.isEmpty()){

            Integer val1 = l1.removeFirst();
            Integer val2 = (Integer) l2.removeFirst();

            //System.out.println("Dump Remove : " + val1 + "|" + val2);

            if(val1.compareTo(val2) != 0){
                System.out.println("Dump Remove : " + val1 + "|" + val2);
                System.out.println("Something went wrong for SinglyLinkedList Implementation");
                throw new RuntimeException("Something went wrong for SinglyLinkedList Implementation");
            }
        }

        System.out.println("SinglyLinkedList implementation works fine");
    }

    private void testStackInterface(List<Integer> randomList) {
        SinglyLinkedList<Integer> stack = new SinglyLinkedList<>();
        Stack<Integer> stack1 = new Stack<>();

        Random random = new Random();
        for(Integer i: randomList){

            //System.out.println("Push : " + i);

            stack.push(i);
            stack1.push(i);

            if(random.nextBoolean() && !stack.isEmpty()) {
                int q1 = stack.pop();
                int q2 = stack1.pop();

                //System.out.println("Do Pop (Compare) : " + q1 + "|" + q2);

                if(q1 != q2){
                    System.out.println("THE STACK INTERFACE FOR SINGLYLINKEDLIST IS BROKEN !!!! ");
                    throw new RuntimeException("THE STACK INTERFACE FOR SINGLYLINKEDLIST IS BROKEN !!!! ");
                }
            }
        }

        System.out.println("Stack Size : " + stack1.size());

        while(!stack.isEmpty()){
            Integer l = stack.pop();
            Integer j = stack1.pop();

            //System.out.println("STACK QUEUE : " + l + "|" + j);

            if(l.compareTo(j) != 0){
                System.out.println("THE STACK INTERFACE FOR SINGLYLINKEDLIST IS BROKEN !!!! ");
                throw new RuntimeException("THE STACK INTERFACE FOR SINGLYLINKEDLIST IS BROKEN !!!! ");
            }
        }

        System.out.println("The STACK INTERFACE FOR SINGLYLINKEDLIST works fine");
    }

    private void testQueueInterface(List<Integer> randomList) {
        SinglyLinkedList<Integer> queue = new SinglyLinkedList();
        Queue<Integer> queue2 = new LinkedList<Integer>();

        Random random = new Random();
        for(Integer i: randomList){

            //System.out.println("Enqueue : " + i);
            queue.enqueue(i);
            queue2.add(i);

            if(random.nextBoolean() && !queue.isEmpty()) {
                int q1 = queue.dequeue();
                int q2 = queue2.poll();

                //System.out.println("Do Dequeue (Compare) : " + q1 + "|" + q2);

                if(q1 != q2){
                    System.out.println("THE QUEUE IMPLEMENTATION IS BROKEN !!!! ");
                    throw new RuntimeException("THE QUEUE IMPLEMENTATION IS BROKEN !!!! ");
                }
            }
        }

        System.out.println("Queue Size : " + queue2.size());

        while(!queue.isEmpty()){
            Integer l = queue.dequeue();
            Integer j = queue2.poll();

            //System.out.println("DUMP QUEUE : " + l + "|" + j);

            if(l.compareTo(j) != 0){
                System.out.println("THE QUEUE INTERFACE FOR SINGLYLINKEDLIST IS BROKEN !!!! ");
                throw new RuntimeException("THE QUEUE INTERFACE FOR SINGLYLINKEDLIST IS BROKEN !!!! ");
            }
        }

        System.out.println("The QUEUE INTERFACE FOR SINGLYLINKEDLIST works fine");
    }

    private void testReverse(List<Integer> randomList) {
        SinglyLinkedList<Integer> testReverse = new SinglyLinkedList<>();

        for(Integer i : randomList ){
            testReverse.addLast(i);
        }

        testReverse.reverse();
        Collections.reverse(randomList);

        for(Integer i: randomList){
            Integer l = testReverse.removeFirst();

            //System.out.println("DUMP SINGLYLINKEDLIST : " + l + "|" + i);

            if(l.compareTo(i) != 0){
                System.out.println("THE REVERSE IMPLEMENTATION FOR SINGLYLINKEDLIST IS BROKEN !!!! ");
                throw new RuntimeException("THE REVERSE IMPLEMENTATION FOR SINGLYLINKEDLIST IS BROKEN !!!! ");
            }
        }

        System.out.println("The REVERSE IMPLEMENTATION FOR SINGLYLINKEDLIST works fine");
    }
}