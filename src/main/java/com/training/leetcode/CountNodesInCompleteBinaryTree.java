package com.training.leetcode;

public class CountNodesInCompleteBinaryTree {

    static class TreeNode{
        int val;
        TreeNode left, right;

        TreeNode(int value) {
            val = value;
        }
    }
    public int countNodes(TreeNode root){
        if(root == null) return 0;

//        int height = 0;
//        TreeNode left = root, right = root;
//
//        while(right != null){
//            left = left.left;
//            right = right.right;
//            height++;
//        }
//        // Complete binary tree with leaf nodes in left and right extremes
//        if(left == null){
//            int n =  (1 << height) - 1; // 2^(h + 1) - 1
//            return n;
//        }
//        int n =  1 + countNodes(root.left) + countNodes(root.right);
//        return n;

        int height = getHeight(root), n = 0;
        TreeNode node = root;
        while(node != null){
            if(getHeight(node.right) == height - 1){
                n += (1 << height)  ;
                node = node.right;
            } else {
                n += (1 << height - 1);
                node = node.left;
            }
            height--;
        }
        return n;
    }

    public int getHeight(TreeNode node){

        int height = 0;
        while(node.left != null){
            node = node.left;
            height++;
        }
        return height;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);

        System.out.println(new CountNodesInCompleteBinaryTree().countNodes(root));

    }
}
