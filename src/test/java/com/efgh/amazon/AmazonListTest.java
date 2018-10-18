package com.efgh.amazon;

import org.junit.Assert;
import org.junit.Test;

public class AmazonListTest {

    @Test
    public void testCreationDummy(){
        AmazonList list = new AmazonList("O", "M", "G");
        Assert.assertEquals("[O,M,G]", list.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreationNull(){
        new AmazonList(null);
    }

    @Test
    public void testCreationEmpty(){
        AmazonList list = new AmazonList();
        Assert.assertEquals("[]", list.toString());
    }

    @Test
    public void testCreationNumbers(){
        AmazonList list = new AmazonList(1,2,3);
        Assert.assertEquals("[1,2,3]", list.toString());
    }

    @Test
    public void testReverse(){
        AmazonList list = new AmazonList(1,2,3,4);
        Assert.assertEquals("[4,3,2,1]", list.reverse().toString());
    }

    @Test
    public void testReverseEmpty(){
        AmazonList list = new AmazonList();
        Assert.assertEquals("[]", list.reverse().toString());
    }

    @Test
    public void testReverseSingleValue(){
        AmazonList list = new AmazonList(1);
        Assert.assertEquals("[1]", list.reverse().toString());
    }

    @Test
    public void testFilter(){
        Assert.assertEquals("[2,4]", (new AmazonList<>(1,2,3,4)).filter(x -> x % 2 == 0).toString());
    }

    @Test
    public void testFilterString(){
        Assert.assertEquals("[a]", (new AmazonList<>("a", "b", "c")).filter(x -> x.equals("a")).toString());
    }

    @Test
    public void testFilterNoResults(){
        Assert.assertEquals("[]", (new AmazonList<>(1,2,3,4)).filter(x -> x > 5).toString());
    }

    @Test
    public void testMapString(){
        Assert.assertEquals("[A,B,C]", (new AmazonList<>("a", "b", "c")).map(x -> x.toUpperCase()).toString());
    }

    @Test
    public void testMapStringEmpty(){
        Assert.assertEquals("[A,B,C]", (new AmazonList<>("a", "b", "c")).map(x -> x.toUpperCase()).toString());
    }

    @Test
    public void testMapStringNull(){
        Assert.assertEquals("[A,null,C]", (new AmazonList<>("a", null, "c")).map(x -> x.toUpperCase()).toString());
    }



}
