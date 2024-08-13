package com.training.leetcode;

public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = nums[n - 1];
        int suffixSum = nums[n - 1];
        for(int i = n - 2; i >= 0; i--){
            suffixSum += nums[i];
            suffixMax[i] = Math.max(suffixMax[i + 1], suffixSum);
        }
        int prefixMax = nums[0], currMax = 0, prefixSum = 0, specialSum = nums[0];
        for(int i = 0; i < n; i++){
            currMax = Math.max(currMax, 0) + nums[i];
            prefixMax = Math.max(prefixMax, currMax);
            prefixSum += nums[i];
            if(i + 1 < n){
                specialSum = Math.max(specialSum, prefixMax + suffixMax[i + 1]);
            }
        }

        return Math.max(prefixMax, specialSum);
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSumCircularSubarray().maxSubarraySumCircular(new int[]{1,-2,3,-2}));
        System.out.println(new MaximumSumCircularSubarray().maxSubarraySumCircular(new int[]{5,-3,5}));

    }
}
