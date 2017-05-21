package com.curioustake.clrs.activity;

import com.curioustake.clrs.algorithms.HeapSort;
import com.curioustake.clrs.utils.ListHelper;

import java.util.Arrays;
import java.util.List;

public class HeapSortActivity implements Activity {

    public void invoke(String[] args) {
        System.out.println( "Execute => " + Arrays.toString(args) );

        final int count = Integer.parseInt(args[1]);
        final int max = Integer.parseInt(args[2]);

        List<Integer> randomList = ListHelper.getRandomList(count, max);
        //ListHelper.printList("Original : ", randomList);

        long startTime = System.currentTimeMillis();
        HeapSort.sort(randomList);
        long endTime = System.currentTimeMillis();
        System.out.println("Running Time : " + (endTime - startTime) + " ms");
        //ListHelper.printList("Sorted : ", randomList);

        System.out.println("IsSorted : " + ListHelper.isSortted(randomList));

    }
}
