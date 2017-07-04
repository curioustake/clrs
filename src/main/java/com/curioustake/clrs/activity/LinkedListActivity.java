package com.curioustake.clrs.activity;

import com.curioustake.clrs.datastructure.LinkedList;
import com.curioustake.clrs.utils.ListHelper;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LinkedListActivity implements Activity{

    @Override
    public void invoke(String[] args) {
        System.out.println( "Execute => " + Arrays.toString(args) );

        final int count = Integer.parseInt(args[1]);
        final int max = Integer.parseInt(args[2]);

        List<Integer> randomList = ListHelper.getRandomList(count, max);
        //ListHelper.printList("Original : ", randomList);

        LinkedList<Integer> l1 = new LinkedList<>();
        java.util.LinkedList l2 = new java.util.LinkedList();

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
                        boolean b1 = l1.search(i);
                        boolean b2 = l2.contains(i);

                        //System.out.println("Search result for (" + i + ") : " + b1 + "|" + b2);

                        if( b1 ^ b2 ) {
                            System.out.println("Inconsistent search result");
                            throw new RuntimeException("Inconsistent search result");
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

        while (!l2.isEmpty()){
            if(!l1.delete((Integer)l2.removeFirst())){
                System.out.println("Something went wrong for LinkedList Implementation");
                throw new RuntimeException("Something went wrong for LinkedList Implementation");
            }
        }

        System.out.println("LinkedList implementation works fine");

    }
}
