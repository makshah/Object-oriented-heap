package main;
/*
* Heap decorator class is made Scalable in order to make it...
* OddHeapDecorator or any other (EvenHeapDecorator, NegativeHeapDecorator) in future.
*/

import main.Heap;

import java.util.Iterator;

abstract class HeapDecorator {
    Heap localHeap;

    public HeapDecorator(Heap heap){
        this.localHeap = heap;
    }
    public String toString(){
        return localHeap.toString();
    }

    public Integer[] toArray(){
        return localHeap.toArray();
    }

    public Iterator<Integer> internalIterator(){
        return localHeap.internalIterator();
    }
}
