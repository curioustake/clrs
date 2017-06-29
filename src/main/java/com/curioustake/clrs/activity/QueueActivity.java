package com.curioustake.clrs.activity;

import com.curioustake.clrs.datastructure.Queue;
import com.curioustake.clrs.utils.ListHelper;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class QueueActivity implements Activity{

    @Override
    public void invoke(String[] args) {
        System.out.println( "Execute => " + Arrays.toString(args) );

        final int count = Integer.parseInt(args[1]);
        final int max = Integer.parseInt(args[2]);

        List<Integer> randomList = ListHelper.getRandomList(count, max);
        //ListHelper.printList("Original : ", randomList);

        Queue<Integer> queue = new Queue<>();
        java.util.Queue<Integer> queue2 = new LinkedList<Integer>();

        int blah = 0;
        Random random = new Random();
        for(Integer i: randomList){

            queue.enqueue(i);
            queue2.add(i);

            if(random.nextBoolean() && !queue2.isEmpty()) { blah++;
                int q1 = queue.dequeue();
                int q2 = queue2.poll();

                //System.out.println("Do Pop (Compare) : " + q1 + "|" + q2);

                if(q1 != q2){
                    System.out.println("THE QUEUE IMPLEMENTATION IS BROKEN !!!! ");
                    throw new RuntimeException("THE QUEUE IMPLEMENTATION IS BROKEN !!!! ");
                }
            }
        }

        System.out.println("Blah " + blah);

        while(!queue2.isEmpty()){
            Integer i = queue.dequeue();
            Integer j = queue2.poll();

            //System.out.println(i + "|" + j);

            if(i.compareTo(j) != 0){
                System.out.println("THE QUEUE IMPLEMENTATION IS BROKEN !!!! ");
                throw new RuntimeException("THE QUEUE IMPLEMENTATION IS BROKEN !!!! ");
            }
        }

        System.out.println("The QUEUE implementation works fine");
    }
}
