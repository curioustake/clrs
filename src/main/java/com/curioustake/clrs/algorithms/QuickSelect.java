package com.curioustake.clrs.algorithms;

import java.util.List;
import java.util.Random;

public class QuickSelect {

    public static  <T extends Comparable> T select(List<T> list, int orderStatisticToBeSelected){
        return select(list, 0, list.size()-1, orderStatisticToBeSelected);
    }

    private static  <T extends Comparable> T select(List<T> list, int startIndex, int endIndex,int orderStatisticToBeSelected) {
        if(endIndex - startIndex == 0) {
            return list.get(endIndex);
        }

        Random random = new Random();
        int randomPivotIndex = startIndex + random.nextInt(endIndex - startIndex);

        swap(list, randomPivotIndex, endIndex);

        int pivotSortedIndex = partition(list, startIndex, endIndex);

        if(pivotSortedIndex == orderStatisticToBeSelected){
            return list.get(pivotSortedIndex);
        } else if(pivotSortedIndex > orderStatisticToBeSelected) {
            return select(list, startIndex, pivotSortedIndex - 1, orderStatisticToBeSelected);
        } else {
            return select(list, pivotSortedIndex + 1, endIndex, orderStatisticToBeSelected);
        }
    }

    private static <T extends Comparable> int partition(List<T> list, int startIndex, int endIndex) {
        int lowBound = startIndex - 1;

        T pivot = list.get(endIndex);

        for(int i=startIndex; i<endIndex; i++){
            if(list.get(i).compareTo(pivot) <= 0){
                swap(list, lowBound+1, i);
                lowBound++;
            }
        }
        swap(list, lowBound+1, endIndex);
        return lowBound+1;
    }

    private static <T extends Comparable> void swap(List<T> list, final int startIndex, final int endIndex) {
        T temp = list.get(endIndex);
        list.set(endIndex, list.get(startIndex));
        list.set(startIndex, temp);
    }
}
