package com.curioustake.clrs.activity;

import com.curioustake.clrs.algorithms.QuickSelect;
import com.curioustake.clrs.utils.ListHelper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuickSelectActivity implements Activity {
    @Override
    public void invoke(String[] args) {
        System.out.println("Execute => " + Arrays.toString(args));

        final int count = Integer.parseInt(args[1]);
        final int max = Integer.parseInt(args[2]);

        Random random = new Random();
        final int orderStatisticToBeSelected = random.nextInt(count -1);
        System.out.println("Order Statistic to Select : " + orderStatisticToBeSelected);

        // Quick Select
        List<Integer> randomList = ListHelper.getRandomList(count, max);
        //ListHelper.printList("RandomList :", randomList);
        long startTime = System.currentTimeMillis();
        Integer selectedItem = QuickSelect.select(randomList, orderStatisticToBeSelected-1);
        long endTime = System.currentTimeMillis();
        System.out.println("QuickSelect Item : " +  selectedItem);
        System.out.println("QuickSelect Running Time : " + (endTime - startTime) + " ms");

        // Control (Collections.sort) select
        startTime = System.currentTimeMillis();
        Collections.sort(randomList);
        //ListHelper.printList("Sorted List :", randomList);
        Integer controlSelectedItem = randomList.get(orderStatisticToBeSelected-1);
        System.out.println("Control Selected Item : " + controlSelectedItem);
        endTime = System.currentTimeMillis();
        System.out.println("Control Running Time : " + (endTime - startTime) + " ms");

        System.out.println("IsSelectedItemCorrect : " +  (controlSelectedItem.compareTo(selectedItem) == 0 )+ "\n");
        randomList.clear();
    }
}
