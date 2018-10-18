/**
1. Complexity for all of the implemented operations is O(n) if we dont take into account the storage/comparisson effort
2. No concurrent handling implemented, could have been done with a synchronized implementation tho.
*/

package com.efgh.amazon;

import java.util.function.Function;
import java.util.function.Predicate;

public class AmazonList<T> {

    AmazonListNode<T> initialNode;
    AmazonListNode<T> lastNode;

    public AmazonList(T... values){
        if(values == null){
            throw new IllegalArgumentException("Null is not a valid initialization value");
        }
        for(int i = 0; i < values.length; i++){
            add(values[i]);
        }
    }

    void add(T value){
        AmazonListNode<T> newNode = new AmazonListNode<>(value);
        if(lastNode != null){
            newNode.setPreviousNode(lastNode);
            lastNode.setNextNode(newNode);
        }
        lastNode = newNode;
        if(initialNode == null){
            initialNode = newNode;
        }
    }

    AmazonList<T> reverse(){
        AmazonList<T> newList = new AmazonList<>();
        AmazonListNode<T> currentNode =  lastNode;
        while (currentNode != null){
            newList.add(currentNode.getValue());
            currentNode = currentNode.getPreviousNode();
        }
        return newList;
    }

    AmazonList<T> filter(Predicate<? super T> predicate){
        AmazonList<T> newList = new AmazonList<>();
        AmazonListNode<T> currentNode = initialNode;
        while (currentNode != null){
            if(predicate.test(currentNode.getValue())){
                newList.add(currentNode.getValue());
            }
            currentNode = currentNode.getNextNode();
        }
        return newList;
    }

    <R> AmazonList<R> map(Function<? super T, ? extends R> mapper){
        AmazonList<R> newList = new AmazonList<>();
        AmazonListNode<T> currentNode = initialNode;
        while (currentNode != null){
            try{
                newList.add(mapper.apply(currentNode.getValue()));
            }catch (NullPointerException e){
                e.printStackTrace();
                newList.add(null);
            }
            currentNode = currentNode.getNextNode();
        }
        return newList;
    }

    <R> AmazonList<R> foldLeft(Function<? super T, ? extends R> mapper){
		//PENDING
        AmazonList<R> newList = new AmazonList<>();
        AmazonListNode<T> currentNode = initialNode;
        while (currentNode != null){
            try{
                newList.add(mapper.apply(currentNode.getValue()));
            }catch (NullPointerException e){
                e.printStackTrace();
                newList.add(null);
            }
            currentNode = currentNode.getNextNode();
        }
        return newList;
    }

    @Override
    public String toString() {
        String result = "[";
        AmazonListNode<T> currentNode =  initialNode;

        while (currentNode != null){
            result += String.valueOf(currentNode.getValue());
            currentNode = currentNode.getNextNode();
            if(currentNode != null){
                result += ",";
            }
        }
        return result + "]";
    }
}