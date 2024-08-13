package com.training.leetcode;

import java.util.Arrays;

public class ValidateBinaryTreeNodes {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        int[] parent = new int[n];
        Arrays.fill(parent, Integer.MAX_VALUE);
        parent[0] = -1;
        for(int i = 0; i < n; i++){

            int left_node = leftChild[i];
            int right_node = rightChild[i];
            if(left_node != -1) {
                if(parent[left_node] == -1 || parent[left_node] != Integer.MAX_VALUE) return false;
                parent[left_node] = i;
            }

            if(right_node != -1) {
                if(parent[right_node] ==-1 || parent[right_node] != Integer.MAX_VALUE) return false;
                parent[right_node] = i;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidateBinaryTreeNodes().validateBinaryTreeNodes(4, new int[]{1,-1,3,-1}, new int[]{2,-1,-1,-1}));
    }
}
