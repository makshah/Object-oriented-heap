package main;

/*
* TO follow the Null Object Pattern these nodes will not have any value stored in them.
* Used to eliminate any Null checks in the code.
*/


public class NullNode extends Node {
    public NullNode() {
        this(null, null, null, null);
    }

    private NullNode(Integer value, Node leftNode, Node rightNode, Node parent){
        super(value, leftNode, rightNode, parent);
    }

    @Override
    public boolean isNull(){
        return true;
    }
}
