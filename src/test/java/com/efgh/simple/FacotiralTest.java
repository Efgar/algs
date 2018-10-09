package com.efgh.simple;

import org.junit.Assert;
import org.junit.Test;

public class FacotiralTest {
    Factorial fact = new Factorial();

    @Test
    public void simpleTest(){
        Assert.assertEquals(1, fact.factorial(1));
        Assert.assertEquals(4, fact.factorial(4));
        Assert.assertEquals(0, fact.factorial(5));
        Assert.assertEquals(6, fact.factorial(3));
        Assert.assertEquals(0, fact.factorial(500));
    }

    @Test
    public void negativesTest() {
        Assert.assertEquals(1, fact.factorial(-1));
    }

    @Test
    public void zeroTest() {
        Assert.assertEquals(1, fact.factorial(0));
    }
}
