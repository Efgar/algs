package com.efgh.simple;

/**
 * Write a method binarySearch that searches an array of integers for a given integer using the Binary Search Algorithm. If the input integer is found in the array - return index of that item. Otherwise, return -1.
 *
 * Notes:
 * You may assume that the given array of integers is already sorted in ascending order.
 * Using java framework to solve it is forbidden - you have to code it by yourself.
 * You have to implement binary search - it cannot be solved through traversing array, or other sort algorithm
 * Example
 * [2,5,7,11,15], 11 -> 3
 */
public class BinarySearch {

    /**
     * @param arr An array of Integers
     * @param n element to find
     * @return  Index of element if found or -1 if absent
     */
    public int binarySearch(int[] arr, int n) {
        return binarySearch(arr, n, 0, arr.length);
    }


    /**
     * @param arr An array of Integers
     * @param n element to find
     * @param l leftmost element of the array
     * @param r leftmost element of the array
     * @return  Index of element if found or -1 if absent
     */
    public int binarySearch(int[] arr, int n, int l, int r) {
        return -1;
    }
}
