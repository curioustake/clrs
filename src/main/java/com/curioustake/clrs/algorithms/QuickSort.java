package com.curioustake.clrs.algorithms;

import java.util.List;

public class QuickSort {

    public static <T extends Comparable> void sort(List<T> list) {
        sort(list, 0, list.size()-1);
    }

    protected static <T extends Comparable> void sort(List<T> list, final int startIndex, final int endIndex) {

        if(list.size() < 2)
            return;

        final int pivotInitialIndex = getPivot(list, startIndex, endIndex);
        swap(list, endIndex, pivotInitialIndex);

        final int pivotSortedIndex = partition(list, startIndex, endIndex);

        if((pivotSortedIndex - 1 - startIndex) > 0) {
            sort(list, startIndex, (pivotSortedIndex-1));
        }

        if((endIndex - (pivotSortedIndex + 1)) > 0) {
            sort(list, pivotSortedIndex+1, endIndex);
        }
    }

    protected static <T extends Comparable> int getPivot(List<T> list, final int startIndex, final int endIndex){
        return endIndex;
    }

    protected static <T extends Comparable> int partition(List<T> list, final int startIndex, final int endIndex) {
        int lowBoundary = startIndex-1;
        int highBoundary = startIndex-1;
        
        T pivotValue = list.get(endIndex);
        
        for(int i=startIndex; i<endIndex; i++){
            T currentValue = list.get(i);

            if((currentValue.compareTo(pivotValue)) > 0) {
                highBoundary = i;
            } else if((currentValue.compareTo(pivotValue)) <= 0) {
                if(highBoundary > lowBoundary){
                    swap(list, i, lowBoundary+1);
                    highBoundary = i;
                }

                lowBoundary++;
            }
        }

        int pivotSortedIndex = lowBoundary + 1;
        swap(list, pivotSortedIndex, endIndex);
        
        return pivotSortedIndex;
    }

    private static <T extends Comparable> void swap(List<T> list, final int first, final int second) {
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }
}
