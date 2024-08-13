package com.training.leetcode;



public class UncrossedLines {
    int m, n;
    int[][] memo;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        m = nums1.length; n = nums2.length;
//         memo = new int[m][n];
//        for(int i = 0; i < m; i++){
//            Arrays.fill(memo[i], -1);
//        }
//        return dp(0,0, nums1, nums2);
        memo = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(nums1[i - 1] == nums2[j - 1]){
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                } else {
                    memo[i][j] = Math.max(memo[i][j - 1], memo[i - 1][j]);
                }
            }
        }
        return memo[m][n];
    }
    public int dp(int i, int j, int[] nums1, int[] nums2){
        if(i >= m || j >= n) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        if(nums1[i] == nums2[j]){
            memo[i][j] = 1 + dp(i + 1, j + 1, nums1, nums2);
        } else {
            memo[i][j] = Math.max(dp(i + 1, j, nums1, nums2), dp(i, j + 1, nums1, nums2));
        }
        return memo[i][j];
    }

    public static void main(String[] args) {
        System.out.println(new UncrossedLines().maxUncrossedLines(new int[]{1,4,2}, new int[]{1,2,4}));
        System.out.println(new UncrossedLines().maxUncrossedLines(new int[]{1,2,3}, new int[]{1,2,3}));
    }
}
