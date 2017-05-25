package com.curioustake.clrs.activity;

import com.curioustake.clrs.algorithms.HoareQuickSort;
import com.curioustake.clrs.algorithms.QuickSort;
import com.curioustake.clrs.algorithms.RandomizedQuickSort;
import com.curioustake.clrs.utils.ListHelper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSortActivity implements Activity{

    @Override
    public void invoke(String[] args) {
        System.out.println( "Execute => " + Arrays.toString(args) );

        final int count = Integer.parseInt(args[1]);
        final int max = Integer.parseInt(args[2]);

        // QuickSort
        List<Integer> randomList = ListHelper.getRandomList(count, max);
        long startTime = System.currentTimeMillis();
        QuickSort.sort(randomList);
        long endTime = System.currentTimeMillis();
        System.out.println("QuickSort Running Time : " + (endTime - startTime) + " ms");
        //ListHelper.printList("Sorted : ", randomList);
        System.out.println("IsSorted : " + ListHelper.isSortted(randomList) + "\n");
        randomList.clear();

        // RandomizedQuickSort
        randomList = ListHelper.getRandomList(count, max);
        startTime = System.currentTimeMillis();
        RandomizedQuickSort.sort(randomList);
        endTime = System.currentTimeMillis();
        System.out.println("RandomizedQuickSort Running Time : " + (endTime - startTime) + " ms");
        //ListHelper.printList("Sorted : ", randomList);
        System.out.println("IsSorted : " + ListHelper.isSortted(randomList) + "\n");
        randomList.clear();

        // HoareQuickSort
        //Integer []temp = {56, 15, 23, 39, 95, 5, 8, 29, 39, 56, 40, 50, 37, 52, 19, 15, 87, 74, 30, 64};
        //randomList = Arrays.asList(temp);

        randomList = ListHelper.getRandomList(count, max);
        //ListHelper.printList("Random : ", randomList);
        startTime = System.currentTimeMillis();
        HoareQuickSort.sort(randomList);
        endTime = System.currentTimeMillis();
        System.out.println("HoareQuickSort Running Time : " + (endTime - startTime) + " ms");
        //ListHelper.printList("Sorted : ", randomList);
        System.out.println("IsSorted : " + ListHelper.isSortted(randomList) + "\n");
        //randomList.clear();

        // Collections.sort
        randomList = ListHelper.getRandomList(count, max);
        startTime = System.currentTimeMillis();
        Collections.sort(randomList);
        endTime = System.currentTimeMillis();
        System.out.println("Collections.sort Running Time : " + (endTime - startTime) + " ms");
        //ListHelper.printList("Sorted : ", randomList);
        System.out.println("IsSorted : " + ListHelper.isSortted(randomList) + "\n");

    }
}
