package com.training.leetcode;

public class MinOperationsToReduceXtoZero {
    public int minOperations(int[] nums, int x) {
        int maxLength = -1;
        int total = 0, n = nums.length;
        for(int num : nums){
            total += num;
        }
        int window_sum = 0;
        for(int l = 0, r = 0; r < n; r++){
            window_sum += nums[r];
            while(l <= r && window_sum > total - x) window_sum -= nums[l++];
            if(window_sum == total - x) maxLength = Math.max(maxLength, n - (r - l) + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new MinOperationsToReduceXtoZero().minOperations(new int[]{1,5,3,9,1,7,1,3}, 18));
    }
}
