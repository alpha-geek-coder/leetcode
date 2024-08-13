package com.training.leetcode;

import java.util.*;

public class MaxValueKCoins {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int dp[][] = new int[n + 1][k + 1];
        for (int curr = 1; curr <= n; curr++) {
            for (int coins = 0; coins <= k; coins++) {
                int coinsTakenSum = 0;
                // Coins taken from curr - 1 pile
                for (int coinsTaken = 0; coinsTaken <= Math.min((int)piles.get(curr - 1).size(), coins); coinsTaken++) {
                    if (coinsTaken > 0) {
                        coinsTakenSum += piles.get(curr - 1).get(coinsTaken - 1);
                    }
                    dp[curr][coins] = Math.max(dp[curr][coins], dp[curr - 1][coins - coinsTaken] + coinsTakenSum);
                }
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        List<List<Integer>> piles = new ArrayList<>();
        piles.add(Arrays.asList(1,100,3));
        piles.add(Arrays.asList(7,8,9));
        System.out.println(new MaxValueKCoins().maxValueOfCoins(piles, 2));

    }
}
