package com.curioustake.clrs.activity;

import com.curioustake.clrs.datastructure.Stack;
import com.curioustake.clrs.utils.ListHelper;

import java.util.Arrays;
import java.util.List;

public class StackActivity implements Activity{

    @Override
    public void invoke(String[] args) {
        System.out.println( "Execute => " + Arrays.toString(args) );

        final int count = Integer.parseInt(args[1]);
        final int max = Integer.parseInt(args[2]);

        List<Integer> randomList = ListHelper.getRandomList(count, max);
        //ListHelper.printList("Original : ", randomList);

        Stack<Double> stack = new Stack();
        java.util.Stack stackJava = new java.util.Stack();
        for(Integer i: randomList){
            stack.push(i.doubleValue());
            stackJava.push(i.doubleValue());
        }

        if(stack.isEmpty()) System.out.println("WTF !!! The stack is empty");

        while(!stack.isEmpty()){
            Double val1 = stack.pop();
            Double val2 = (Double)stackJava.pop();
            //System.out.println(val1 + "|" + val2);
            if(val1.compareTo(val2) != 0) {
                System.out.println("THE STACK IMPLEMENTATION IS BROKEN !!!! ");
                throw new RuntimeException("THE STACK IMPLEMENTATION IS BROKEN !!!! ");
            }
        }

        System.out.println("The Stack works fine");
    }
}
