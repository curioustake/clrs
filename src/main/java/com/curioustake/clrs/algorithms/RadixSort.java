package com.curioustake.clrs.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RadixSort {

    public static List<Integer> sort(List<Integer> list) {

        int maxDigits = String.valueOf(Collections.max(list)).length();

        for(int i=0; i<maxDigits; i++){
            list = sortByCharAtIndex(list, i);
        }

        return list;
    }

    private static List<Integer> sortByCharAtIndex(List<Integer> list, int sortingIndex){

        List<Integer> occurrenceScore = new ArrayList<>(Collections.nCopies(12, 0));

        for(Integer i: list) {
            String numStr = String.valueOf(i);
            int occurrenceIndex = (numStr.length() > sortingIndex) ? Character.getNumericValue(numStr.charAt(numStr.length() - 1 - sortingIndex)) : 0;
            occurrenceScore.set(occurrenceIndex+1, (occurrenceScore.get(occurrenceIndex+1)+1));
        }

        for(int i=1; i<occurrenceScore.size(); i++){
            occurrenceScore.set(i, occurrenceScore.get(i) + occurrenceScore.get(i- 1));
        }

        List<Integer> sortedByCharAtIndex = new ArrayList<>(Collections.nCopies(list.size(), 0));

        for (int i=list.size()-1; i>=0; i--){
            String numStr = String.valueOf(list.get(i));
            int occurrenceIndex = (numStr.length() > sortingIndex) ? Character.getNumericValue(numStr.charAt(numStr.length() - 1 - sortingIndex)) : 0;
            sortedByCharAtIndex.set(occurrenceScore.get(occurrenceIndex+1)-1, list.get(i));
            occurrenceScore.set(occurrenceIndex+1, occurrenceScore.get(occurrenceIndex+1) - 1);
        }

        return sortedByCharAtIndex;
    }
}
