package com.training.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinCostClimbingStaits {
    Map<Integer, Integer> memo = new HashMap<>();
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(dp(cost, 0), dp(cost, 1));
    }
    public int dp(int[] cost, int step){
        if(step >= cost.length) return 0;
        if(!memo.containsKey(step)){
            memo.put(step, Math.min(dp(cost,step + 1), dp(cost, step + 2)) + cost[step]);
        }
        return memo.get(step);
    }
}
