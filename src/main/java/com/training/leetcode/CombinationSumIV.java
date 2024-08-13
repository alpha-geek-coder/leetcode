package com.training.leetcode;

import java.util.Arrays;

public class CombinationSumIV {
    int[] memo;
    public int combinationSum4(int[] nums, int target) {
        memo = new int[target + 1];
        memo[0] = 1;
        Arrays.fill(memo, -1);
        return dp(nums, target);
    }

    public int dp(int[] nums, int target){
        if(target < 0) return 0;
        if(target == 0) return 1;
        if(memo[target] != -1) return memo[target];
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            ans += dp(nums, target - nums[i]);
        }
        memo[target] = ans;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSumIV().combinationSum4(new int[]{1,2,3}, 4));
    }
}
