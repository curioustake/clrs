package com.curioustake.clrs.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ListHelper {

    public static List<Integer> getRandomList(int count, int max){
        List<Integer> randomList = new ArrayList<>();
        Random random = new Random();

        for (int i=0; i< count; i++) {
            randomList.add(random.nextInt(max));
        }

        return randomList;
    }

    public static <T> void printList(final String message, final List<T> list){
        System.out.println(message + Arrays.toString(list.toArray()));
    }

    public static <T extends Comparable> T findMax(final List<T> list){
        T max = list.get(0);
        for (T i : list) {
            if(max.compareTo(i) < 0)
                max = i;
        }
        return max;
    }

    public static <T extends Comparable> boolean isSorted(final List<T> list){
        for (int i=1; i<list.size(); i++){
            if(list.get(i).compareTo(list.get(i-1)) < 0)
                return false;
        }
        return true;
    }
}
