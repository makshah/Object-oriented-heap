package main;
/*
* The heap will be made up of InternalNode nodes.
* Unlike NullNode these nodes will store values in them and might have leftChild, rightChild and parentNode.
*/


public class InternalNode extends Node {
    public InternalNode(Integer value, Node leftNode, Node rightNode, Node parent) {
        super(value, leftNode, rightNode, parent);
    }

    @Override
    public boolean isNull() {
        return false;
    }
}