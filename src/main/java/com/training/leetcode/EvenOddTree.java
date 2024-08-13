package com.training.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
1609. Even Odd Tree

Medium

A binary tree is named Even-Odd if it meets the following conditions:

The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.
For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).
For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).
Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false.

 */
public class EvenOddTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        int level = 0;
        q.add(root);
        boolean even = true;
        while(!q.isEmpty()){
            int size = q.size();
            int prev = -1;
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if(even){
                    // even-indexed level
                    if(curr.val % 2 == 0 || (prev != -1 && prev >= curr.val)){
                        return false;
                    }
                } else {
                    // odd-indexed level
                    if(curr.val % 2 != 0 || (prev != -1 && prev <= curr.val)){
                        return false;
                    }
                }
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                prev = curr.val;
            }
            even = !even;

        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(7);
        System.out.println(new EvenOddTree().isEvenOddTree(root));
    }
}
