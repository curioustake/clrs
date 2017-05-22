package com.curioustake.clrs.algorithms;

import com.curioustake.clrs.datastructure.Heap;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedLists {
    public static <T extends Comparable> List<T> merge(final List<List<T>> lists){

        List<ListTuple<T>> listTuples = new ArrayList<>();
        for (List<T> list: lists) {
            listTuples.add(new ListTuple<>(list));
        }

        List<T> mergedList = new ArrayList();
        T currentMax = null;
        do {
            Heap<ListTuple<T>> listTupleHeap = new Heap<>(listTuples, Heap.HEAP_TYPE.MIN);
            currentMax = listTupleHeap.max().removeMax();
            if(currentMax != null)
                mergedList.add(currentMax);
        } while (currentMax != null);

        return mergedList;
    }

    private static class ListTuple<T extends Comparable> implements Comparable<ListTuple<T>>{
        private List<T> sortedList;
        private int currentMaxIndex;

        private ListTuple(List<T> sortedList){
            this.sortedList = sortedList;
            this.currentMaxIndex = 0;
        }

        private T currentMax(){
            return currentMaxIndex < sortedList.size() ? sortedList.get(currentMaxIndex) : null;
        }

        private T removeMax(){
            T max = currentMax();
            currentMaxIndex++;
            return max;
        }

        @Override
        public int compareTo(ListTuple<T> o) {
            if(this.currentMax() == null){
                if(o.currentMax() == null){
                    return 0;
                } else {
                    return -1;
                }
            } else {
                if(o.currentMax() == null){
                    return 1;
                }
            }

            return this.currentMax().compareTo(o.currentMax());
        }
    }
}
