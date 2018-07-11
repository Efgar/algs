package com.efgh.structures.linkedlist;


class LinkedListNode{

    private Object value;
    private LinkedListNode nextNode;
    private LinkedListNode previousNode;

    public LinkedListNode(Object nodeValue) {
        setValue(nodeValue);
    }

    public int hashCode(){
        return value.hashCode();
    }

    public boolean equals(Object otherNode){
        return this.hashCode() == otherNode.hashCode();
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public LinkedListNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(LinkedListNode nextNode) {
        this.nextNode = nextNode;
    }

    public LinkedListNode getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(LinkedListNode previousNode) {
        this.previousNode = previousNode;
    }
}
