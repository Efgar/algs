package com.efgh.simple;

import org.junit.Assert;
import org.junit.Test;

public class TwoSumTest {
    TwoSum twosum = new TwoSum();

    @Test
    public void simpleTest(){
        Assert.assertArrayEquals(twosum.twoSum(new int[]{2,7,11,15}, 9), new int[]{1,2});
    }

    @Test
    public void separatedTest(){
        Assert.assertArrayEquals(twosum.twoSum(new int[]{2,7,11,15}, 17), new int[]{1,4});
    }

    @Test
    public void negativesTest(){
        Assert.assertArrayEquals(twosum.twoSum(new int[]{-2,7,11,15}, 5), new int[]{1,2});
    }

    @Test
    public void negativesSeparatedTest(){
        Assert.assertArrayEquals(twosum.twoSum(new int[]{2,7,-11,15}, -9), new int[]{1,3});
    }

    @Test(expected = IllegalArgumentException.class)
    public void smallArrayTest(){
        twosum.twoSum(new int[]{2}, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidInputTest(){
        twosum.twoSum(new int[]{2,7,11,15}, 30);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidInputTest_repeated(){
        twosum.twoSum(new int[]{2,7,11,15}, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidInputTest_null(){
        twosum.twoSum(null, 2);
    }
}
