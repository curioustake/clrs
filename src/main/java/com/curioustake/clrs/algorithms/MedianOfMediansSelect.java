package com.curioustake.clrs.algorithms;

import java.util.ArrayList;
import java.util.List;

// THIS SHIT IS BROKEN !!!!!FIX IT!!!!!!!!!!!!!
public class MedianOfMediansSelect {

    public static  <T extends Comparable> T select(List<T> list, int orderStatisticToBeSelected){
        return select(list, 0, list.size()-1, orderStatisticToBeSelected);
    }

    private static  <T extends Comparable> T select(List<T> list, int startIndex, int endIndex,int orderStatisticToBeSelected) {
        if(endIndex - startIndex == 0) {
            return list.get(endIndex);
        }

        T medianPivot = getMedianOfMedians(list, startIndex, endIndex);
        for(int i=startIndex; i<endIndex; i++){
            if(medianPivot.compareTo(list.get(i)) == 0){
                swap(list, i, endIndex);
                break;
            }
        }

        int pivotSortedIndex = partition(list, startIndex, endIndex);

        if(pivotSortedIndex == orderStatisticToBeSelected){
            return list.get(pivotSortedIndex);
        } else if(pivotSortedIndex > orderStatisticToBeSelected) {
            return select(list, startIndex, pivotSortedIndex - 1, orderStatisticToBeSelected);
        } else {
            return select(list, pivotSortedIndex + 1, endIndex, orderStatisticToBeSelected);
        }
    }

    private static <T extends Comparable> T getMedianOfMedians(List<T> list, int startIndex, int endIndex) {
        if((endIndex - startIndex) < 5)
            return getMedian(list, startIndex, endIndex);

        List<T> medians =  new ArrayList<>();

        for(int i=startIndex; i<=endIndex;){
            int end = (i+4 <= endIndex) ? i+4 : endIndex;
            T median = getMedian(list, i, end);
            medians.add(median);
            i = end+1;
        }

        return getMedianOfMedians(medians, 0, medians.size()-1);
    }

    private static <T extends Comparable> T getMedian(List<T> list, int startIndex, int endIndex) {
        InsertionSort.sort(list, startIndex, endIndex);
        Double median = Math.ceil((endIndex-startIndex)/2);
        return list.get(median.intValue());
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
