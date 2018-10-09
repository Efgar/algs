package com.efgh.simple;

import com.efgh.structures.Tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class CountLeafsTest {
    CountLeafs countLeafs = new CountLeafs();

    @Test
    public void simpleTest(){
        TreeNode root = new TreeNode();
        root.right = new TreeNode();
        root.left = new TreeNode();
        Assert.assertEquals(2, countLeafs.countLeaves(root));
    }

    @Test
    public void unbalancedTest(){
        TreeNode root = new TreeNode();
        root.right = new TreeNode();
        Assert.assertEquals(1, countLeafs.countLeaves(root));
    }

    @Test
    public void deeperTreeTest(){
        TreeNode root = new TreeNode();
        root.right = new TreeNode();
        TreeNode leftBranch = new TreeNode();
        leftBranch.right = new TreeNode();
        leftBranch.left = new TreeNode();
        root.left = leftBranch;
        Assert.assertEquals(3, countLeafs.countLeaves(root));
    }

    @Test
    public void nullTreeTest(){
        TreeNode root = null;
        Assert.assertEquals(0, countLeafs.countLeaves(root));
    }
}
