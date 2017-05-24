package com.curioustake.clrs.activity;

import com.curioustake.clrs.algorithms.QuickSort;
import com.curioustake.clrs.algorithms.RandomizedQuickSort;
import com.curioustake.clrs.utils.ListHelper;

import java.util.Arrays;
import java.util.List;

public class QuickSortActivity implements Activity{

    @Override
    public void invoke(String[] args) {
        System.out.println( "Execute => " + Arrays.toString(args) );

        final int count = Integer.parseInt(args[1]);
        final int max = Integer.parseInt(args[2]);

        List<Integer> randomList = ListHelper.getRandomList(count, max);
        //ListHelper.printList("Original : ", randomList);

        // QuickSort
        long startTime = System.currentTimeMillis();
        QuickSort.sort(randomList);
        long endTime = System.currentTimeMillis();
        System.out.println("QuickSort Running Time : " + (endTime - startTime) + " ms");
        //ListHelper.printList("Sorted : ", randomList);
        System.out.println("IsSorted : " + ListHelper.isSortted(randomList));

        // RandomizedQuickSort
        startTime = System.currentTimeMillis();
        RandomizedQuickSort.sort(randomList);
        endTime = System.currentTimeMillis();
        System.out.println("RandomizedQuickSort Running Time : " + (endTime - startTime) + " ms");
        //ListHelper.printList("Sorted : ", randomList);
        System.out.println("IsSorted : " + ListHelper.isSortted(randomList));

    }
}
