package com.curioustake.clrs.datastructure;

import java.util.List;

public class Heap<T extends Comparable>{
    List<T> elements;
    long heapSize;
    HEAP_TYPE heapType;

    public enum HEAP_TYPE{ MAX, MIN};

    public Heap(List<T> elements){
        this(elements, elements.size(), HEAP_TYPE.MAX);
    }

    public Heap(List<T> elements, long heapSize){
        this(elements, heapSize, HEAP_TYPE.MAX);
    }

    public Heap(List<T> elements, HEAP_TYPE heapType){
        this(elements, elements.size(), heapType);
    }

    public Heap(List<T> elements, long heapSize, HEAP_TYPE heapType){
        this.elements = elements;
        this.heapSize = heapSize;
        this.heapType = heapType;
        int lastNonLeafNodeIndex = new Double(Math.ceil(heapSize/2) - 1).intValue();

        for(;lastNonLeafNodeIndex>=0;lastNonLeafNodeIndex-- )
            heapify(lastNonLeafNodeIndex);
    }

    public long getHeapSize(){
        return heapSize;
    }

    private void heapify(int nodeIndex){

        //System.out.println("\n");
        final int leftIndex = ((2*nodeIndex) + 1) >= heapSize ? -1 : ((2*nodeIndex) + 1);
        final int rightIndex = ((2*nodeIndex) + 2) >= heapSize ? -1 : ((2*nodeIndex) + 2);
/*
        System.out.println("Node  " + nodeIndex);
        System.out.println("Left " + leftIndex);
        System.out.println("Right " + rightIndex);
*/
        if(leftIndex < 0){
            return;
        }

        int maxIndex = leftIndex;
        if(rightIndex > 0 && validateHeapProperty(elements.get(rightIndex), elements.get(leftIndex))){
            maxIndex = rightIndex;
        }

        if(validateHeapProperty(elements.get(maxIndex), elements.get(nodeIndex))){
            T temp = elements.get(nodeIndex);
            elements.set(nodeIndex, elements.get(maxIndex));
            elements.set(maxIndex, temp);
            //System.out.println("maxIndex " + maxIndex + " | "+ elements.get(maxIndex));
            //System.out.println("nodeIndex " + nodeIndex + " | " + elements.get(nodeIndex));
            heapify(maxIndex);
        }
    }

    private boolean validateHeapProperty(T obj1, T obj2){
        if(heapType.equals(HEAP_TYPE.MAX))
            return obj1.compareTo(obj2) > 0;
        else
            return obj1.compareTo(obj2) < 0;
    }

    public T max(){
        return elements.get(0);
    }
}
