// A Java Class to handle the MaxHeap addValue logic

package main;

public class MaxHeap implements HeapStrategy{

    @Override
    public int compareNodes(Node node1, Node node2) {
        if(node1.getValue() < node2.getValue()){
            return -1;
        }
        else if(node1.getValue() == node2.getValue()){
            return 0;
        }
        return 1;
    }
}
