package com.efgh.simple;


import com.efgh.structures.Tree.TreeNode;

/**
 * Write a method countLeaves to find the total number of leaf nodes in a binary tree. If there is no leaf nodes, return 0…
 *
 * Example
 * 1
 * / \
 * 2   3     ==> # count = 4
 * / \ / \
 * 4  5 6  7
 */
public class CountLeafs {

    /**
     * @param root Root of binary tree (TreeNode)
     * @return  Number of leaf nodes
     */
    public int countLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return countLeaves(root.left) + countLeaves(root.right);
    }
}
