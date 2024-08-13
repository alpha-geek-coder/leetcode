package com.training.leetcode;

public class CheckSubtree {

    public boolean containsTree(TreeNode t1, TreeNode t2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        preOrderTraversal(t1, s1);
        preOrderTraversal(t2, s2);

        return s1.indexOf(s2.toString()) != -1;
    }

    public void preOrderTraversal(TreeNode node, StringBuilder sb) {

        if(node == null){
            sb.append("X");
            return ;
        }

        sb.append(node.val);

        preOrderTraversal(node.left, sb);

        preOrderTraversal(node.right, sb);



    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(4);

        TreeNode t2 = new TreeNode(3);
        t2.left = new TreeNode(4);

        System.out.println(new CheckSubtree().containsTree(t1, t2));
    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            val = value;
        }
    }
}
