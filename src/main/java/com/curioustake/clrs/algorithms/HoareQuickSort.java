package com.curioustake.clrs.algorithms;

import java.util.List;

public class HoareQuickSort extends QuickSort {
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
            sort(list, startIndex, (pivotSortedIndex)-1);
        }

        if((endIndex - (pivotSortedIndex + 1)) > 0) {
            sort(list, pivotSortedIndex+1, endIndex);
        }
    }

    protected static <T extends Comparable> int partition(List<T> list, final int startIndex, final int endIndex) {
        int lowBoundary = startIndex;
        int highBoundary = endIndex - 1;

        T pivotValue = list.get(endIndex);

        while (true){
            while((lowBoundary < highBoundary) && list.get(lowBoundary).compareTo(pivotValue) <= 0){
                lowBoundary++;
            }

            while((lowBoundary < highBoundary) && list.get(highBoundary).compareTo(pivotValue) > 0){
                highBoundary--;
            }

            if(lowBoundary < highBoundary)
                swap(list, lowBoundary, highBoundary);
            else
                break;
        }

        int pivotSortedIndex = endIndex;
        if(list.get(lowBoundary).compareTo(pivotValue) > 0){
            swap(list, lowBoundary, endIndex);
            pivotSortedIndex = lowBoundary;
        }

        return pivotSortedIndex;
    }
}

