package com.curioustake.clrs.activity;

import com.curioustake.clrs.algorithms.CountingSort;
import com.curioustake.clrs.utils.ListHelper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountingSortActivity implements Activity{
    public void invoke(String[] args) {
        System.out.println( "Execute => " + Arrays.toString(args) );

        final int count = Integer.parseInt(args[1]);
        final int max = Integer.parseInt(args[2]);

        // Counting Sort
        List<Integer> randomList = ListHelper.getRandomList(count, max);
        //ListHelper.printList("RandomList :", randomList);
        long startTime = System.currentTimeMillis();
        List sortedList = CountingSort.sort(randomList);
        long endTime = System.currentTimeMillis();
        System.out.println("CountingSort Running Time : " + (endTime - startTime) + " ms");
        //ListHelper.printList("Sorted : ", sortedList);
        System.out.println("IsSorted : " + ListHelper.isSorted(sortedList) + "\n");
        randomList.clear();

        // Collections.sort
        randomList = ListHelper.getRandomList(count, max);
        startTime = System.currentTimeMillis();
        Collections.sort(randomList);
        endTime = System.currentTimeMillis();
        System.out.println("Collections.sort Running Time : " + (endTime - startTime) + " ms");
        //ListHelper.printList("Sorted : ", randomList);
        System.out.println("IsSorted : " + ListHelper.isSorted(randomList) + "\n");
    }
}
