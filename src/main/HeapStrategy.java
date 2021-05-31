// Interface to determine how to handle the Heap iterations with respect to the Heap type (min or max)
package main;

public interface HeapStrategy {
    int compareNodes(Node node1, Node node2);
}