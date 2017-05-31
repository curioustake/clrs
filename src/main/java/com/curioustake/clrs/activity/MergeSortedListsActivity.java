package com.curioustake.clrs.activity;

import com.curioustake.clrs.algorithms.MergeSortedLists;
import com.curioustake.clrs.utils.ListHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeSortedListsActivity implements Activity {
    public void invoke(String[] args) {
        System.out.println( "Execute => " + Arrays.toString(args) );

        final int count = Integer.parseInt(args[1]);
        final int max = Integer.parseInt(args[2]);
        final int listCount = Integer.parseInt(args[3]);

        List<List<Integer>> sortedLists = new ArrayList<>();
        for (int i=listCount; i>0 ;i--){
            List<Integer> randomList = ListHelper.getRandomList(count, max);
            Collections.sort(randomList);
            //HeapSort.sort(randomList);
            sortedLists.add(randomList);
            //ListHelper.printList("List " + i , randomList);
        }

        long startTime = System.currentTimeMillis();
        List mergedList = MergeSortedLists.merge(sortedLists);
        //ListHelper.printList("mergedList ", mergedList);
        long endTime = System.currentTimeMillis();
        System.out.println("MergedList in " + (endTime - startTime) + "ms");

        System.out.println("MergedList IsSorted : " + ListHelper.isSorted(mergedList));

    }
}
