package main;

import java.util.Iterator;

public class HeapIterator implements Iterator<Integer>{
    private Node currentNode;
    public HeapIterator(Node root) {
        this.currentNode = root;
        if (!this.currentNode.isNull()) {
            while (!this.currentNode.getLeftChild().isNull()) {
                this.currentNode = this.currentNode.getLeftChild();
            }
        }
    }

    public boolean hasNext() {
            return !currentNode.isNull();
    }

    public Integer next() {
        Node localNode = currentNode;
        if (!this.currentNode.getRightChild().isNull()) {
            this.currentNode = this.currentNode.getRightChild();
            while (!this.currentNode.getLeftChild().isNull()) {
                this.currentNode = this.currentNode.getLeftChild();
            }
        } else while (true) {
            if (this.currentNode.getParentNode().isNull()) {
                this.currentNode = new NullNode();
                return localNode.getValue();
            }

            if (this.currentNode.getParentNode().getLeftChild() == this.currentNode) {
                this.currentNode = this.currentNode.getParentNode();
                return localNode.getValue();
            }
            this.currentNode = this.currentNode.getParentNode();
        }
        return localNode.getValue();
    }
}