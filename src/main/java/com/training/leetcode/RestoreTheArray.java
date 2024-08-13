package com.training.leetcode;

public class RestoreTheArray {
    int mod = 1000000007;
    public int numberOfArrays(String s, int k) {
        int n = s.length();
        int[] dp = new int[n + 1];
        return dfs(s, k, dp, 0);
    }

    public int dfs(String s, int k, int[] dp, int start){
        // if start idx is greater the string length
        if(start >= s.length()) return 1;
        // if pre-computed recursive call
        if(dp[start] != 0) return dp[start];
        // if integer starting with leading zeros, invalid integer, ignore
        if(s.charAt(start) == '0') return 0;

        int count = 0;
        for(int end = start; end < s.length(); end++){
            String curr = s.substring(start, end + 1);
            if(Long.parseLong(curr) > k) break; // curr must be in range [1,k]
            count = (count + dfs(s, k, dp, end + 1)) % mod;
        }
        dp[start] = count;

        return dp[start];

    }

    public static void main(String[] args) {
        System.out.println(new RestoreTheArray().numberOfArrays("1317", 2000));
    }
}
