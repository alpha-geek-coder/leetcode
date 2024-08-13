package com.training.leetcode;

public class UniquePaths {
    /*
    There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

 Example 1:
Input: m = 3, n = 7
Output: 28

Example 2:
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
     */

    int m = 0, n = 0;
    int[][] memo;

    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        memo = new int[m][n];

        int ans = dfs(0, 0);

        return ans;
    }

    public int dfs(int row, int col){

        if(row >= m || col >= n) return 0;

        if(row == m - 1 && col == n - 1) return 1;

        if(memo[row][col] == 0) {
            memo[row][col] = dfs(row + 1, col) + dfs(row, col + 1);
        }

        return memo[row][col];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(3, 7));
    }
}
