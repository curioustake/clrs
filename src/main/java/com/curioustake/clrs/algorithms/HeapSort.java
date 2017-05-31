package com.curioustake.clrs.algorithms;

import com.curioustake.clrs.datastructure.Heap;

import java.util.List;

public class HeapSort {
    public static <T extends Comparable> void sort(final List<T> list) {
        int heapSize = list.size();
        do {
            Heap<T> heap = new Heap(list, heapSize);
            T temp = list.get(0);
            list.set(0, list.get(heapSize-1));
            list.set(heapSize-1, temp);
            -- heapSize;
        }while (heapSize > 1);

    }
}
