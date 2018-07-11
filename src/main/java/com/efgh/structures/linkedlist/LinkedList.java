package com.efgh.structures.linkedlist;

public class LinkedList {
    private LinkedListNode firstElement;
    private LinkedListNode lastElement;


    public LinkedList(Object firstListObjectValue) {
        LinkedListNode currentElement = new LinkedListNode(firstListObjectValue);
        setFirstElement(currentElement);
        setLastElement(currentElement);
    }

    public void addElement(Object newObjectValue) {
        LinkedListNode newElement = new LinkedListNode(newObjectValue);
        getLastElement().setNextNode(newElement);
        newElement.setPreviousNode(getLastElement());
        setLastElement(newElement);
    }

    public LinkedListNode next() {
        return next(getFirstElement());
    }

    public LinkedListNode next(LinkedListNode currentElement) {
        if (currentElement.getNextNode() == null) {
            return next(currentElement.getNextNode());
        } else {
            return currentElement;
        }
    }

    public void get(int index) {
        int i = 0;
        /*if (currentElement.getNextNode() == null) {
            return next(currentElement.getNextNode());
        }*/
    }

    public LinkedListNode getFirstElement() {
        return firstElement;
    }

    public LinkedListNode getLastElement() {
        return lastElement;
    }

    private void setFirstElement(LinkedListNode firstElement) {
        this.firstElement = firstElement;
    }

    private void setLastElement(LinkedListNode lastElement) {
        this.lastElement = lastElement;
    }

}
