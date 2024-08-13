package com.training.leetcode;

import java.util.Arrays;

public class LongestIdealString {
    public int longestIdealString(String s, int k) {

        int n = s.length();

        int[][] dp = new int[n][26];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int ans = 0;
        for(int c = 0; c < 26; c++){
            System.out.println("Start c = " + c + " i.e. c = " + (char)('a' + c));
            ans = Math.max(ans, dfs(n - 1, c, dp, s, k));
            System.out.println("End c = " + c);
        }

        return ans;
    }

    public int dfs(int i, int c, int[][] dp, String s, int k){
        System.out.println("enter:dfs i = " + i + " , c = " + c + " ,dp[i][c]= " + dp[i][c]);
        if(dp[i][c] != -1){
            System.out.println("enter:dfs i = " + i + " , c = " + c + " ,dp[i][c]= " + dp[i][c]);
            return dp[i][c];
        }

        dp[i][c] = 0;
        System.out.println("init dp["+ i + "]["+ c + "] = 0");
        boolean match = c == (s.charAt(i) - 'a');
        System.out.println("match? c == s.charAt(i) " + (char)('a' + c) + "==" + s.charAt(i) + ">>" + match);
        if(match){
            dp[i][c] = 1;
        }

        if(i > 0){
            System.out.println("inside " + i + " > 0");
            dp[i][c] = dfs(i - 1, c, dp, s, k);
            if(match){
                System.out.println("inside " + i + " > 0 and match found");
                for(int p = 0; p < 26; p++){
                    System.out.println("p = " + p + " , c = " + c);
                    System.out.println("p-char = " + (char)('a' + p) + ", c-char = " + (char)('a' + c));
                    if(Math.abs(p - c) <= k){
                        dp[i][c] = Math.max(dp[i][c], dfs(i - 1, p, dp, s, k) + 1);
                    }
                }
            }
        }
        return dp[i][c];
    }

    public static void main(String[] args) {
        System.out.println(new LongestIdealString().longestIdealString("pvjcci", 4));
    }
}
