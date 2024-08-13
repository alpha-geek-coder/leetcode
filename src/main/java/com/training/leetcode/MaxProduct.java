package com.training.leetcode;

public class MaxProduct {
    public int maxProduct(int[] nums) {

        int[] dp = new int[nums.length];

        int max = nums[0], min = nums[0], result = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int tmp = max;
            max = Math.max(max * nums[i], Math.max(min * nums[i], nums[i]));
            min = Math.min(tmp * nums[i], Math.min(min * nums[i], nums[i]));

            result = Math.max(result, max);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProduct().maxProduct(new int[] {2,3,-2,4}));
    }
}
