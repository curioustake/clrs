package com.curioustake.clrs.datastructure;

import java.util.List;

public class Heap<T extends Comparable>{
    List<T> elements;
    long heapSize;

    public Heap(List<T> elements, long heapSize){
        this.elements = elements;
        this.heapSize = heapSize;
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
        if(rightIndex > 0 && elements.get(rightIndex).compareTo(elements.get(leftIndex)) > 0){
            maxIndex = rightIndex;
        }

        if(elements.get(maxIndex).compareTo(elements.get(nodeIndex)) > 0){
            T temp = elements.get(nodeIndex);
            elements.set(nodeIndex, elements.get(maxIndex));
            elements.set(maxIndex, temp);
            //System.out.println("maxIndex " + maxIndex + " | "+ elements.get(maxIndex));
            //System.out.println("nodeIndex " + nodeIndex + " | " + elements.get(nodeIndex));
            heapify(maxIndex);
        }
    }

    public T max(){
        return elements.get(0);
    }
}
