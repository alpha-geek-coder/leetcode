package com.training.leetcode;

public class SegmentTree {
    int[] segmentTree;
    public int[] buildSegmentTree(int[] nums){

        if(nums.length == 0) return new int[0];
        int n = nums.length;
        segmentTree = new int[n];

        buildTree(nums, 0, 0, n - 1);

        return segmentTree;
    }

    public void buildTree(int[] nums, int node, int left, int right){
        if(left == right){
            segmentTree[node] = nums[left];
            return;
        }
        int mid = (left + right) / 2;
        buildTree(nums, 2 * node, left, mid);
        buildTree(nums, 2 * node + 1, mid + 1, right);
        segmentTree[node] = segmentTree[2 * node] + segmentTree[2 * node + 1];

        return;
    }

    public void add(int[] nums, int idx, int val){
        if(idx < 0 || idx >= nums.length) return;
        updateTree(nums, 0, 0, nums.length - 1, idx, val);
        return;
    }

    public void updateTree(int[] nums, int node, int left, int right, int idx, int val){
        if(left == right){
            nums[idx] += val;
            segmentTree[node] += val;
            return;
        }
        int mid = (left + right) / 2;
        if(left <= idx && idx <= mid){
            updateTree(nums, 2 * node, left, mid, idx, val);
        } else {
            updateTree(nums, 2 * node + 1, mid + 1, right, idx, val);
        }
        segmentTree[node] = segmentTree[2 * node] + segmentTree[2 * node + 1];
        return;
    }



    public static void main(String[] args) {
        Integer n1 = new Integer(100);
        Integer n2 = new Integer(100);
        System.out.println((n1 == n2) + ":" + (n1.equals(n2)));
    }
}
