package com.curioustake.clrs.algorithms;

import java.util.List;
import java.util.Random;

public class RandomizedQuickSort extends QuickSort {

    public static <T extends Comparable> void sort(List<T> list) {
        sort(list, 0, list.size()-1);
    }

    protected static <T extends Comparable> void sort(List<T> list, final int startIndex, final int endIndex) {

        if(list.size() < 2)
            return;

        final int pivotInitialIndex = getPivot(startIndex, endIndex);
        swap(list, endIndex, pivotInitialIndex);

        final int pivotSortedIndex = partition(list, startIndex, endIndex);

        if((pivotSortedIndex - 1 - startIndex) > 0) {
            sort(list, startIndex, (pivotSortedIndex-1));
        }

        if((endIndex - (pivotSortedIndex + 1)) > 0) {
            sort(list, pivotSortedIndex+1, endIndex);
        }
    }

    protected static int getPivot(final int startIndex, final int endIndex){
        Random random = new Random();
        int randomizedPivotIndex =  random.nextInt(endIndex - startIndex);

        return startIndex + randomizedPivotIndex;
    }
}
