package com.curioustake.clrs.activity;

import com.curioustake.clrs.datastructure.Heap;
import com.curioustake.clrs.utils.ListHelper;

import java.util.Arrays;
import java.util.List;

public class HeapActivity implements Activity{
    public void invoke(String[] args) {
        System.out.println( "Execute => " + Arrays.toString(args) );

        final int count = Integer.parseInt(args[1]);
        final int max = Integer.parseInt(args[2]);

        List<Integer> randomList = ListHelper.getRandomList(count, max);
        //ListHelper.printList("Original : ", randomList);

        Heap heap = new Heap(randomList, randomList.size());
        System.out.println("Test Max : " + ListHelper.findMax(randomList));
        System.out.println("Heap Max : " + heap.max());
    }

}
