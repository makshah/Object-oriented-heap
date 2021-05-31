// User needs to pass the type of Heap (MinHeap or MaxHeap) as an argument when instantiating the Heap.

package main;

import java.util.Iterator;

public class Runner {
    public static void main(String[] args) {
        Heap minHeap = new Heap(new MinHeap());
        int[] nodeValues = {10, 20, -1, 9 , 0};
        boolean successfulInput = true;
        int arrayIndex = 0;
        while(successfulInput && arrayIndex < nodeValues.length){
            successfulInput = minHeap.addValue(nodeValues[arrayIndex]);
            System.out.println(nodeValues[arrayIndex] + " successfully added to the Heap");
            if(!successfulInput){
                System.out.println("Unsuccessful Input");
                break;
            }
            arrayIndex++;
        }

        HeapIterator heapIterator = new HeapIterator(minHeap.getRoot());
        System.out.println("**********************************************************");
        System.out.println("Inorder traversal using an External Iterator:");
        while(heapIterator.hasNext()){
            System.out.println(heapIterator.next());
        }

        System.out.println("**********************************************************");
        System.out.println("Inorder traversal using an Internal Iterator:");
        Iterator<Integer> internalIterator = minHeap.internalIterator();
        while(internalIterator.hasNext()){
            System.out.println((int) internalIterator.next());
        }

        System.out.println("**********************************************************");
        System.out.println("Printing the elements of the Array received from the toArray function of Heap:");
        Integer[] nodesArray = minHeap.toArray();
        for(int node : nodesArray){
            System.out.println(node);
        }

        System.out.println("**********************************************************");
        String nodesString = minHeap.toString();
        System.out.println("Output from the toString function of the Heap:");
        System.out.println(nodesString);

        System.out.println("**********************************************************");
        System.out.println("Printing the elements using the OddFilter class:");
        OddFilter oddFilter = new OddFilter(minHeap.internalIterator());
        while (oddFilter.hasNext()){
            System.out.println(oddFilter.next());
        }

        System.out.println("**********************************************************");
        System.out.println("OddDecorator Class active:");
        OddHeapDecorator oddHeapDecorator = new OddHeapDecorator(minHeap);
        Integer[] decoratorArray = oddHeapDecorator.toArray();

        System.out.println("Printing the elements of the Array received from the toArray function of Decorator Class:");
        for(int element : decoratorArray){
            System.out.println(element);
        }

        System.out.println("**********************************************************");
        String decoratorString = oddHeapDecorator.toString();
        System.out.println("Output from the toString of the OddDecorator class:");
        System.out.println(decoratorString);
    }
}
