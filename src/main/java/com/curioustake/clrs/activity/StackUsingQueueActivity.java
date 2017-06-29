package com.curioustake.clrs.activity;

import com.curioustake.clrs.datastructure.StackUsingQueue;
import com.curioustake.clrs.utils.ListHelper;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StackUsingQueueActivity implements Activity{

    @Override
    public void invoke(String[] args) {
        System.out.println( "Execute => " + Arrays.toString(args) );

        final int count = Integer.parseInt(args[1]);
        final int max = Integer.parseInt(args[2]);

        List<Integer> randomList = ListHelper.getRandomList(count, max);
        //ListHelper.printList("Original : ", randomList);

        StackUsingQueue<Double> stackUsingQueue = new StackUsingQueue<>();
        java.util.Stack stackJava = new java.util.Stack();

        Random random = new Random();

        for(Integer i: randomList){
            stackUsingQueue.push(i.doubleValue());
            stackJava.push(i.doubleValue());

            if(random.nextBoolean() && !stackUsingQueue.isEmpty()) {
                Double q1 = stackUsingQueue.pop();
                Double q2 = (Double)stackJava.pop();

                //System.out.println("Do Pop (Compare) : " + q1 + "|" + q2);

                if(q1.compareTo(q2) != 0){
                    System.out.println("THE STACK-USING-QUEUE IMPLEMENTATION IS BROKEN !!!! ");
                    throw new RuntimeException("THE STACK-USING-QUEUE IMPLEMENTATION IS BROKEN !!!! ");
                }
            }
        }

        if(stackUsingQueue.isEmpty()) System.out.println("WTF !!! The stack is empty");

        while(!stackUsingQueue.isEmpty()){
            Double val1 = stackUsingQueue.pop();
            Double val2 = (Double)stackJava.pop();
            //System.out.println(val1 + "|" + val2);
            if(val1.compareTo(val2) != 0) {
                System.out.println("THE STACK-USING-QUEUE IMPLEMENTATION IS BROKEN !!!! ");
                throw new RuntimeException("THE STACK-USING-QUEUE IMPLEMENTATION IS BROKEN !!!! ");
            }
        }

        System.out.println("The Stack-Using-Queue works fine");
    }
}

