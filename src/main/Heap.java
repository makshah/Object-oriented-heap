package main;

import java.util.ArrayList;
import java.util.Iterator;

public class Heap {

    private Node root;
    HeapStrategy strategy;

    public Heap(Object heapType) {
        root = new NullNode();
        if (heapType instanceof MinHeap) {
            strategy = new MinHeap();
        } else {
            strategy = new MaxHeap();
        }
    }

    public boolean addValue(Integer toBeInserted) {
        Node internalNodeToBeInserted = new InternalNode(toBeInserted, new NullNode(), new NullNode(), new NullNode());
        root = insertRecursively(root, internalNodeToBeInserted);
        return true;
    }

    private Node insertRecursively(Node root, Node toBeInserted) {
        if (root.isNull()) {
            return toBeInserted;
        }
        // Strategy pattern will decide how to construct the Heap - MinHeap or MaxHeap
        if (strategy.compareNodes(root, toBeInserted) >= 0) {
            if (!root.hasLeftChild()) {
                root.leftNode = toBeInserted;
                root.leftNode.parentNode = root;
            } else if (!root.hasRightChild()) {
                root.rightNode = toBeInserted;
                root.rightNode.parentNode = root;
            } else if (root.getHeight(root.leftNode) == root.getHeight(root.rightNode)) {
                insertRecursively(root.leftNode, toBeInserted);
            } else if (root.getHeight(root.leftNode) > root.getHeight(root.rightNode)) {
                insertRecursively(root.rightNode, toBeInserted);
            } else {
                insertRecursively(root.leftNode, toBeInserted);
            }
        } else {
            if (strategy.compareNodes(root, toBeInserted) < 0) {
                InternalNode swapNodeValue = new InternalNode(root.getValue(), new NullNode(), new NullNode(), new NullNode());
                root.setValue(toBeInserted.getValue());
                insertRecursively(root, swapNodeValue);
            }
        }
        return root;
    }


    public Node getRoot(){
        return root;
    }

    public Iterator<Integer> internalIterator(){
        return new HeapIterator(root);
    }

    public Integer[] toArray() {
        HeapIterator itr = new HeapIterator(root);
        ArrayList<Integer> array = new ArrayList<>();
        while (itr.hasNext()) {
            array.add(itr.next());

        }
        return array.toArray(new Integer[array.size()]);
    }

    public String toString() {
        HeapIterator itr = new HeapIterator(root);
        StringBuilder str = new StringBuilder();
        while (itr.hasNext()) {
            str.append(itr.next()).append(" ");
        }
        return str.toString();
    }
}
