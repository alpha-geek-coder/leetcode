package com.training.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class CommonAncestorBST {
    /*
    Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
            6
          /   \
         2     8
        / \   / \
       0  4  7   9
         / \
        3   5
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;

        while(node != null){
            if(p.val > node.val && q.val > node.val){
                node = node.right;
            } else if(p.val < node.val && q.val < node.val){
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Integer[] bst = {6,2,8,0,4,7,9,null,null,3,5};
        TreeNode root = new TreeNode(bst[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int idx = 1;
        while(!q.isEmpty() ){
            int size = q.size();
            for(int i = 0 ; i < size; i++){
                TreeNode node = q.poll();
                if(idx < bst.length && bst[idx] != null){
                    node.left = new TreeNode(bst[idx]);
                    q.add(node.left);
                }
                idx++;
                if(idx < bst.length && bst[idx] != null){
                    node.right = new TreeNode(bst[idx]);
                    q.add(node.right);
                }
                idx++;

            }
        }
        System.out.println(new CommonAncestorBST().lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8)).val);
    }
}
