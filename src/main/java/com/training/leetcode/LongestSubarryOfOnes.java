package com.training.leetcode;

public class LongestSubarryOfOnes {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int max_length = 0, count = 0;
        for(int l = 0, r = 0; r < n; r++){
            if(nums[r] == 0) count++;
            if(count > 1 && nums[l++] == 0) count--;
            max_length = Math.max(max_length, r - l);
        }

        return max_length;
    }
}
