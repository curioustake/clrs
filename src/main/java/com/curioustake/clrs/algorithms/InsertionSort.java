package com.curioustake.clrs.algorithms;

import java.util.List;

public class InsertionSort {

    public static <T extends Comparable> void sort(List<T> list) {
        sort(list, 0, list.size()-1);
    }

    public static <T extends Comparable> void sort(List<T> list, final int startIndex, final int endIndex) {
        for(int i=startIndex+1; i<=endIndex; i++){
            int runningIndex = i;
            for(int j=i-1; j>=0; j--){
                if(list.get(runningIndex).compareTo(list.get(j)) < 0){
                    swap(list,runningIndex,j);
                    runningIndex--;
                } else {
                    break;
                }
            }
        }
    }

    private static <T extends Comparable> void swap(List<T> list, int first, int second) {
        T temp = list.get(second);
        list.set(second, list.get(first));
        list.set(first, temp);
    }
}
