package com.curioustake.clrs.activity;

import com.curioustake.clrs.datastructure.Deque;
import com.curioustake.clrs.utils.ListHelper;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DequeActivity implements Activity{

    @Override
    public void invoke(String[] args) {
        System.out.println( "Execute => " + Arrays.toString(args) );

        final int count = Integer.parseInt(args[1]);
        final int max = Integer.parseInt(args[2]);

        List<Integer> randomList = ListHelper.getRandomList(count, max);
        //ListHelper.printList("Original : ", randomList);

        Deque<Integer> deque = new Deque<>();
        java.util.Deque<Integer> deque2 = new LinkedList<Integer>();

        Random random = new Random();
        for(Integer i: randomList) {

            int randomOperation = random.nextInt(4);
            switch (randomOperation){
                case 0:
                    deque.push(i);
                    deque2.push(i);
                    break;
                case 1:
                    if(!deque.isEmpty() && !deque2.isEmpty()){
                        int val1 = deque.pop();
                        int val2 = deque2.pop();

                        //System.out.println("POP COMPARE : " + val1 + "|" + val2);
                        if(val1!=val2)
                            throw new RuntimeException("POP COMPARE FAILED : " + val1 + " !=" + val2);
                    }

                    deque.push(i);
                    deque2.push(i);
                    break;
                case 2:
                    deque.enqueue(i);
                    deque2.add(i);
                    break;
                case 3:
                    if(!deque.isEmpty() && !deque2.isEmpty()){
                        int val1 = deque.dequeue();
                        int val2 = deque2.remove();

                        //System.out.println("DEQUEUE COMPARE : " + val1 + "|" + val2);
                        if(val1!=val2)
                            throw new RuntimeException("DEQUEUE COMPARE FAILED : " + val1 + " !=" + val2);
                    }

                    deque.push(i);
                    deque2.push(i);
                    break;
                default:
                    System.out.println("NO IDEA WHAT IS GOING ON (RANDOM #) : " + randomOperation);
                    throw new RuntimeException("Incorrect deque operation");
            }

        }

        while (!deque.isEmpty() && !deque2.isEmpty()){
            int val1 = deque.dequeue();
            int val2 = deque2.remove();

            //System.out.println("DRAIN COMPARE : " + val1 + "|" + val2);
            if(val1!=val2)
                throw new RuntimeException("DRAIN COMPARE FAILED : " + val1 + " !=" + val2);
        }

        System.out.println("Deque implementation works fine");
    }
}
