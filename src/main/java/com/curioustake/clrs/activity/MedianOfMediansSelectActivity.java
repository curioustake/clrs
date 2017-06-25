package com.curioustake.clrs.activity;

import com.curioustake.clrs.algorithms.MedianOfMediansSelect;
import com.curioustake.clrs.algorithms.QuickSelect;
import com.curioustake.clrs.utils.ListHelper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MedianOfMediansSelectActivity  implements Activity {
    @Override
    public void invoke(String[] args) {
        System.out.println("Execute => " + Arrays.toString(args));

        final int count = Integer.parseInt(args[1]);
        final int max = Integer.parseInt(args[2]);

        Random random = new Random();
        final int orderStatisticToBeSelected = random.nextInt(count -1);
        System.out.println("Order Statistic to Select : " + orderStatisticToBeSelected);

        // Median-Of-Medians Select
        List<Integer> randomList = ListHelper.getRandomList(count, max);
        //ListHelper.printList("RandomList :", randomList);
        long startTime = System.currentTimeMillis();
        Integer selectedItem = MedianOfMediansSelect.select(randomList, orderStatisticToBeSelected);
        long endTime = System.currentTimeMillis();
        System.out.println("MedianOfMediansSelect Item : " +  selectedItem);
        System.out.println("MedianOfMediansSelect Running Time : " + (endTime - startTime) + " ms");

        // Control (Collections.sort) median
        startTime = System.currentTimeMillis();
        Collections.sort(randomList);
        //ListHelper.printList("Sorted List :", randomList);
        Integer controlSelectedItem = randomList.get(orderStatisticToBeSelected);
        System.out.println("Control Selected Item : " + controlSelectedItem);
        endTime = System.currentTimeMillis();
        System.out.println("Control Running Time : " + (endTime - startTime) + " ms");

        System.out.println("IsSelectedItemCorrect : " +  (controlSelectedItem.compareTo(selectedItem) == 0 )+ "\n");
        randomList.clear();
    }
}