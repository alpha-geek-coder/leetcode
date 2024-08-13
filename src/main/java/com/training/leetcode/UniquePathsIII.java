package com.training.leetcode;

public class UniquePathsIII {
    int m, n, zeroes;
    int[][] directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public int uniquePath(int[][] grid){
        m = grid.length; n = grid[0].length;
        int x = 0, y = 0;
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(grid[r][c] == 0){
                    zeroes++;
                }else if(grid[r][c] == 1){
                    x = r; y = c;
                }
            }
        }
        return backtrack(x, y, zeroes, grid);
    }

    public int backtrack(int r, int c, int zeroes, int[][] grid){

        if(r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == -1) return 0;
        if(grid[r][c] == 2) {
            return zeroes == 0 ? 1 : 0; // since start pos also decrements zeroes thus -1
        }
        int originalValue = grid[r][c];
        if(originalValue == 0) zeroes--;

        grid[r][c] = -1; // visited
        int total = 0;
        for(int[] dir : directions){
            total += backtrack(r + dir[0], c + dir[1], zeroes, grid);
        }

        if(originalValue == 0)  zeroes++;
        grid[r][c] = originalValue;
        return total;

    }

    public static void main(String[] args) {
        System.out.println(new UniquePathsIII().uniquePath(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}}));
        System.out.println(new UniquePathsIII().uniquePath(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,0,2}}));
        System.out.println(new UniquePathsIII().uniquePath(new int[][]{{0,1},{2,0}}));

    }
}
