package com.training.leetcode;

public class NumArray {
    int[] tree;
    int[] arr;
    public NumArray(int[] nums) {
        arr = nums;
        int n = nums.length;
        tree = new int[2 * n];
        buildTree(0, 0, n -1);
    }

    public void update(int index, int val) {
        updateTree(0, index, val, 0, arr.length - 1);
    }

    public int sumRange(int left, int right) {
        return queryTree(0, 0, arr.length - 1, left, right);
    }

    public void buildTree(int node, int start, int end){
        if(start > end) return;

        if(start == end){
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            buildTree(2 * node + 1, start, mid);
            buildTree(2 * node + 2, mid + 1, end);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    public void updateTree(int node, int idx, int val, int start, int end){
        if(start > end) return;

        if(start == end){
            arr[idx] = val;
            tree[node] = val;
        } else {
            int mid = (start + end) / 2;
            if(start <= idx && idx <= mid){
                updateTree(2 * node + 1, idx, val, start, mid);
            } else {
                updateTree(2 * node + 2, idx, val, mid + 1, end);
            }
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    public int queryTree(int node, int start, int end, int left, int right){

        if(right < start || end < left){
            return 0; // [left, right] is out of range [start,end]
        }
        if(left <= start && end <= right){
            return tree[node];
        }
        int mid = (start + end) / 2;
        int p1 = queryTree(2 * node + 1, start, mid, left, right);
        int p2 = queryTree(2 * node + 2, mid + 1, end, left, right);

        return p1 + p2;
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{9,-8});
        numArray.update(0,3);
        System.out.println(numArray.sumRange(1,1));
        System.out.println(numArray.sumRange(0,1));
        numArray.update(1,-3);
        System.out.println(numArray.sumRange(0,1));
    }

}
