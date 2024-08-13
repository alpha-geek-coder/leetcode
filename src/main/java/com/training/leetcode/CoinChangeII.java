package com.training.leetcode;

import java.util.Arrays;

public class CoinChangeII {
    int[][] memo;
    public int change(int amount, int[] coins) {
        int n = coins.length;
        memo = new int[n][amount + 1];
        for(int i = 0; i < n; i++){
            Arrays.fill(memo[i], -1);
        }
        return dp(coins, 0, amount);
    }

    public int dp(int[] coins, int i, int amount){
        if(amount == 0) return 1;
        if(i == coins.length) return 0;

        if(memo[i][amount] != -1) return memo[i][amount];
        if(coins[i] > amount){
            return memo[i][amount] = dp(coins, i + 1, amount);
        }
        memo[i][amount] = dp(coins, i, amount - coins[i]) + dp(coins, i + 1, amount);
        return memo[i][amount];
    }

    public static void main(String[] args) {
        System.out.println(new CoinChangeII().change(5, new int[]{1,2,5}));
    }
}
