package com.training.leetcode;

public class MaxConsecutiveOneseIII {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int max_length = 0, count = 0;
        for(int l = 0, r = 0; r < n; r++){
            if(nums[r] == 0) count++;
            while(count > k){
                if(nums[l++] == 0) count--;
            }
            max_length = Math.max(max_length, r - l + 1);
        }

        return max_length;
    }

}
