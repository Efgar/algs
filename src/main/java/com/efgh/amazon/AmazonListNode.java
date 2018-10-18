package com.efgh.amazon;

public class AmazonListNode<T> {
    private T value;
    private AmazonListNode<T> nextNode;
    private AmazonListNode<T> previousNode;

    public AmazonListNode(T value){
        setValue(value);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public AmazonListNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(AmazonListNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    public AmazonListNode<T> getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(AmazonListNode<T> previousNode) {
        this.previousNode = previousNode;
    }


}
