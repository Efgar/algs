package com.efgh.simple;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The method twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 * Note: You may assume that each input would have exactly one solution.
 *
 * Example
 * [2,7,11,15], 9 -> [1,2]
 */
public class TwoSum {
    /**
     * @param numbers An array of Integer
     * @param target target = numbers[index1] + numbers[index2]
     * @return  Indices of the two numbers
     */
    public int[] twoSum(int[] numbers, int target) {
        if(numbers != null) {
            for (int i = 0; i < numbers.length; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    if (numbers[j] + numbers[i] == target) {
                        return new int[]{i + 1, j + 1};
                    }
                }
            }
        }
        throw new IllegalArgumentException("Invalid input");
    }
}
