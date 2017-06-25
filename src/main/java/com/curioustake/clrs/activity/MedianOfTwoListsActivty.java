package com.curioustake.clrs.activity;

import com.curioustake.clrs.algorithms.MedianOfTwoLists;
import com.curioustake.clrs.utils.ListHelper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MedianOfTwoListsActivty implements Activity{
    @Override
    public void invoke(String[] args) {
        System.out.println("Execute => " + Arrays.toString(args));

        final int count = Integer.parseInt(args[1]);
        final int max = Integer.parseInt(args[2]);

        // Median Of Two Lists
        List<Integer> randomList1 = ListHelper.getRandomList(count, max);
        ListHelper.printList("RandomList 1 :", randomList1);
        List<Integer> randomList2 = ListHelper.getRandomList(count, max);
        ListHelper.printList("RandomList 2 :", randomList2);

        long startTime = System.currentTimeMillis();
        Integer selectedItem = MedianOfTwoLists.median(randomList1, randomList2);
        long endTime = System.currentTimeMillis();
        System.out.println("MedianOfTwoLists Item : " +  selectedItem);
        System.out.println("MedianOfTwoLists Running Time : " + (endTime - startTime) + " ms");

        // Control : Merge & Collections.sort
        startTime = System.currentTimeMillis();
        List<Integer> mergedRandomList =  Stream.concat(randomList1.stream(), randomList2.stream()).collect(Collectors.toList());
        Collections.sort(mergedRandomList);
        ListHelper.printList("Sorted List :", mergedRandomList);
        Integer controlSelectedItem = null;

        if(mergedRandomList.size()%2 == 0) {
            int lowerMedian = (mergedRandomList.size()-1)/2;
            int upperMedian = lowerMedian + 1;
            controlSelectedItem = (mergedRandomList.get(lowerMedian) + mergedRandomList.get(upperMedian))/2;
        } else {
            controlSelectedItem = mergedRandomList.get((mergedRandomList.size()-1)/2);
        }

        System.out.println("Control Selected Item : " + controlSelectedItem);
        endTime = System.currentTimeMillis();
        System.out.println("Control Running Time : " + (endTime - startTime) + " ms");

        System.out.println("IsSelectedItemCorrect : " +  (controlSelectedItem.compareTo(selectedItem) == 0 )+ "\n");
    }
}
