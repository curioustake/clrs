package com.curioustake.clrs.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountingSort {

    public static List<Integer> sort(List<Integer> list) {
        List<Integer> numberCounterList = getNumberCounter(list);
        List<Integer> sortedList = new ArrayList<>(Collections.nCopies(list.size(), 0));

        for(int i=list.size()-1; i>=0;i--) {
            int value = list.get(i);
            sortedList.set(numberCounterList.get(value) - 1, value);
            numberCounterList.set(value,numberCounterList.get(value)-1);
        }

        return sortedList;
    }

    public static List<Integer> getNumberCounter(final List<Integer> list) {

        List<Integer> numberCounterList = new ArrayList<>(Collections.nCopies(max(list)+1, 0));

        for (int i = 0; i < list.size(); i++) {
            numberCounterList.set(list.get(i), numberCounterList.get(list.get(i)) + 1);
        }

        for (int i = 1; i < numberCounterList.size(); i++) {
            numberCounterList.set(i, numberCounterList.get(i) + numberCounterList.get(i-1));
        }

        return numberCounterList;

    }

    private static int max (final List<Integer> list){
        Integer max = list.get(0);
        for (int i=1; i<list.size(); i++){
            max = list.get(i) > max ? list.get(i) : max;
        }
        return max;
    }

}