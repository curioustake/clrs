package com.curioustake.clrs.activity;

import com.curioustake.clrs.datastructure.QueueUsingStack;
import com.curioustake.clrs.utils.ListHelper;

import java.util.Arrays;
import java.util.List;

public class QueueUsingStackActivity implements Activity{

    @Override
    public void invoke(String[] args) {
        System.out.println( "Execute => " + Arrays.toString(args) );

        final int count = Integer.parseInt(args[1]);
        final int max = Integer.parseInt(args[2]);

        List<Integer> randomList = ListHelper.getRandomList(count, max);
        //ListHelper.printList("Original : ", randomList);

        QueueUsingStack<Integer> queue = new QueueUsingStack<>();

        for(Integer i: randomList){
            queue.enqueue(i);
        }

        for(Integer i: randomList){
            Integer j = queue.dequeue();
            //System.out.println(i + "|" + j);
            if(i.compareTo(j) != 0){
                System.out.println("THE QUEUE-USING-STACK IMPLEMENTATION IS BROKEN !!!! ");
                throw new RuntimeException("THE QUEUE-USING-STACK IMPLEMENTATION IS BROKEN !!!! ");
            }
        }

        System.out.println("The QUEUE-USING-STACK implementation works fine");
    }
}
