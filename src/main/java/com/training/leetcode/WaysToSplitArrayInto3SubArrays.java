package com.training.leetcode;

public class WaysToSplitArrayInto3SubArrays {
    /*
    A split of an integer array is good if:

    The array is split into three non-empty contiguous subarrays - named left, mid, right respectively from left to right.
    The sum of the elements in left is less than or equal to the sum of the elements in mid, and the sum of the elements
    in mid is less than or equal to the sum of the elements in right.
    Given nums, an array of non-negative integers, return the number of good ways to split nums. As the number may be too large,
    return it modulo 109 + 7.
     */
    enum SearchType {
        FIRST,
        LAST;
    }
    public int waysToSplit(int[] nums) {

        int n = nums.length, ways = 0;

        int mod = (int) Math.pow(10, 9) + 7;

        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];

        for(int i = 1; i < n; i++) prefixSum[i] = prefixSum[i - 1] + nums[i];

        for(int i = 1; i < n; i++) {

            int leftSum = prefixSum[i - 1];
            int midSum = (prefixSum[n - 1] - leftSum) / 2 ;

            if(leftSum > midSum) break;

            // Find midSum idx boundary that satisfies leftSum <= midSum <= rightSum
            // BinarySearch since nums in non-negative ints and prefixSum will always be non-decreasing(sorted)
            int leftMostIdx = binarySearch(prefixSum, leftSum, i, SearchType.FIRST);
            int rightMostIdx = binarySearch(prefixSum, leftSum, i, SearchType.LAST);

            if(leftMostIdx == -1 || rightMostIdx == -1) continue;

            ways = (ways + (rightMostIdx - leftMostIdx + 1) % mod) % mod;

        }

        return ways;
    }

    public int binarySearch(int[] prefixSum, int leftSum, int idx, SearchType type ) {

        int left = idx, right = prefixSum.length - 2, result = -1;

        while(left <= right) {
            int pivot = left + (right - left) / 2;
            int midSum = prefixSum[pivot] - prefixSum[idx - 1];
            int rightSum = prefixSum[prefixSum.length - 1] - prefixSum[pivot];
            if(leftSum <= midSum && midSum <= rightSum) {
                result = pivot;
                if(type == SearchType.FIRST) {
                    right = pivot - 1;
                } else {
                    left = pivot + 1;
                }
            } else if(leftSum > midSum) {
                left = pivot + 1; // increase midSum window
            } else {
                right = pivot - 1; // decrease midSum window
            }
        }
        return  result;
    }

    public static void main(String[] args) {
        System.out.println(new WaysToSplitArrayInto3SubArrays().waysToSplit(new int[] {1,2,2,2,5,0}));
    }

}
