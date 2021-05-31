/*
* Node is made abstract so it can be used as a NullNode or an InternalNode.
*/

package main;

public abstract class Node {
    private Integer value;
    Node leftNode, rightNode, parentNode;

    public Node(Integer value, Node leftNode, Node rightNode, Node parent) {
        setValue(value);
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.parentNode = parent;
    }

    public abstract boolean isNull();

    int getHeight(Node node){
        if(node.isNull()){
            return 0;
        }
        else{
            return (Math.max(getHeight(node.leftNode), getHeight(node.rightNode)) + 1);
        }
    }

    public Integer getValue(){
        return this.value;
    }

    public void setValue(Integer value){
        this.value = value;
    }

    boolean hasLeftChild(){
        if(leftNode.isNull()) return false;
        return true;
    }

    boolean hasRightChild(){
        if(rightNode.isNull()) return false;
        return true;
    }

    Node getLeftChild(){
        return leftNode;
    }

    Node getRightChild(){
        return rightNode;
    }

    Node getParentNode(){
        return parentNode;
    }
}
