package com.curioustake.clrs.activity;

import com.curioustake.clrs.algorithms.InsertionSort;
import com.curioustake.clrs.utils.ListHelper;

import java.util.Arrays;
import java.util.List;

public class InsertionSortActivity implements Activity {

    @Override
    public void invoke(String[] args) {
        System.out.println("Execute => " + Arrays.toString(args));

        final int count = Integer.parseInt(args[1]);
        final int max = Integer.parseInt(args[2]);

        // Insertion Sort
        List<Integer> randomList = ListHelper.getRandomList(count, max);
        //ListHelper.printList("RandomList : ", randomList);
        long startTime = System.currentTimeMillis();
        InsertionSort.sort(randomList);
        long endTime = System.currentTimeMillis();
        System.out.println("InsertionSort Running Time : " + (endTime - startTime) + " ms");
        //ListHelper.printList("Sorted : ", randomList);
        System.out.println("IsSorted : " + ListHelper.isSorted(randomList) + "\n");
        randomList.clear();
    }
}
