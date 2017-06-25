package com.curioustake.clrs.algorithms;

import com.curioustake.clrs.utils.ListHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// THIS SHIT IS BROKEN !!!!!FIX IT!!!!!!!!!!!!!
public class MedianOfTwoLists {
    public static Integer median(List<Integer> list1, List<Integer> list2){
        return median(list1, 0, list1.size()-1, list2, 0, list2.size()-1);
    }

    private static Integer median(List<Integer> list1, int startIndex1, int endIndex1,
                                  List<Integer> list2, int startIndex2, int endIndex2) {

        if((endIndex1 - startIndex1) == 0){
            return (list1.get(startIndex1) + list2.get(startIndex2))/2;
        }

        if((endIndex1 - startIndex1) == 1){
            return (Math.max(list1.get(startIndex1), list2.get(startIndex1)) + Math.min(list1.get(endIndex1), list2.get(endIndex2)))/2;
        }

        int median1 = median(list1, startIndex1, endIndex1);ListHelper.printList("List1 : ", list1);
        int median2 = median(list2, startIndex2, endIndex2);ListHelper.printList("List2 : ", list2);

        if(list1.get(median1).compareTo(list2.get(median2)) == 0){
            return list1.get(median1);
        } else if(list1.get(median1).compareTo(list2.get(median2)) < 0) {
            return median(list1, median1+1, endIndex1, list2, startIndex2, median2-1);
        } else {
            return median(list1, startIndex1, median1-1, list2, median2+1, endIndex2);
        }
    }

    private static  int median(List<Integer> list, int startIndex, int endIndex) {
        int medianIndex = startIndex + ((endIndex - startIndex)/2);

        return select(list, startIndex, endIndex, medianIndex);
    }

    private static  int select(List<Integer> list, int startIndex, int endIndex, int orderStatistic) {
        int randomSelect = randomSelect(list, startIndex, endIndex);

        if(randomSelect == orderStatistic) {
            return randomSelect;
        } else if( randomSelect < orderStatistic){
            return select(list, randomSelect+1, endIndex, orderStatistic);
        } else {
            return select(list, startIndex, randomSelect-1, orderStatistic);
        }
    }

    private static  int randomSelect(List<Integer> list, int startIndex, int endIndex) {
        if((endIndex - startIndex) == 0)
            return startIndex;

        Random random = new Random();
        int randomPivotIndex = startIndex + random.nextInt(endIndex - startIndex + 1); // Bound is exclusive
        swap(list, randomPivotIndex, endIndex);

        int j=startIndex-1;
        for(int i=startIndex; i<endIndex; i++){
            if(list.get(i).compareTo(list.get(endIndex)) <= 0){
                swap(list, (++j), i);
            }
        }
        swap(list, (++j), endIndex);
        return j;
    }

    private static  void swap(List<Integer> list, int firstIndex, int secondIndex){
        Integer temp = list.get(secondIndex);
        list.set(secondIndex, list.get(firstIndex));
        list.set(firstIndex, temp);
    }
}
