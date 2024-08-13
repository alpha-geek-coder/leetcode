package com.training.leetcode;
public class BallFall {
    int m = 0, n = 0;
    public int[] findBall(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int[] ans = new int[n];
        for(int col = 0; col < n; col++){
            ans[col] = dfs(0, col, grid);
        }
        return ans;
    }

    public int dfs(int row, int col, int[][] grid){

        // Condition 1: when ball reaches bottom
        if(row == m) return col;

        //Condition 2 : when ball is stuck
        int nextCol = col + grid[row][col];
        if(nextCol < 0 || nextCol >= n || grid[row][col] != grid[row][nextCol]) {
            return -1;
        }

        return dfs(row + 1, nextCol, grid);

    }

    public static void main(String[] args) {
        int[][] grid1 = new int[][]{{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}};
        printResult(new BallFall().findBall(grid1));

        int[][] grid2 = new int[][]{{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1}};
        printResult(new BallFall().findBall(grid2));

        System.out.println(Integer.BYTES * 8);
    }

    public static void printResult(int[] ans){
        int ball = 0;
        for(int res : ans){
            System.out.println("Ball " + ball + " --> " + res);
            ball++;
        }
    }
}
