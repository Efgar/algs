package com.efgh.simple;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciTest {
    Fibonacci fib = new Fibonacci();

    @Test
    public void fibonacciPremisesTest (){
        Assert.assertEquals(fib.fib(0), 0);
        Assert.assertEquals(fib.fib(1), 1);
    }

    @Test
    public void fibonacciBasicTest (){
        Assert.assertEquals(fib.fib(2), 1);
        Assert.assertEquals(fib.fib(6), 8);
    }

    @Test(expected = IllegalArgumentException.class)
    public void fibonacciNegativeValueTest (){
        fib.fib(-1);
    }

}
