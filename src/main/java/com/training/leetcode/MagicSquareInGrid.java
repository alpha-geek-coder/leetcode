package com.training.leetcode;

public class MagicSquareInGrid {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for (int row = 0; row < m - 2; row++) {
            for (int col = 0; col < n - 2; col++) {
                if(isMagicSquare(grid, row, col)){
                    ans++;
                }
            }
        }

        return ans;

    }

    public boolean isMagicSquare(int[][] grid, int row, int col){
       
        boolean[] distinct = new boolean[10];

        int[] row_sum = new int[3],  col_sum = new int[3];

        for (int r = 0; r < 3 ;  r++) {
            for (int c = 0; c < 3 ;  c++) {
                int num = grid[row + r][col + c];
                if(num < 1 || num > 9 || distinct[num]) {
                    return false;
                } 
                distinct[num] = true;
                row_sum[r] += num;
                col_sum[c] += num;                                       
            }

        }
        
        int ld_sum = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        int rd_sum = grid[row + 2][col] + grid[row + 1][col + 1] + grid[row][col + 2];
        
        if(ld_sum != rd_sum) return false;

        if(row_sum[0] != ld_sum || row_sum[1] != ld_sum || row_sum[2] != ld_sum){
            return false;
        }
        if(col_sum[0] != ld_sum || col_sum[1] != ld_sum || col_sum[2] != ld_sum){
            return false;
        }
        
        return true;
            
    }

    public static void main(String[] args) {
        System.out.println(new MagicSquareInGrid().numMagicSquaresInside(new int[][] {{3,2,9,2,7},{6,1,8,4,2},{7,5,3,2,7},{2,9,4,9,6},{4,3,8,2,5}}));
    }
}
