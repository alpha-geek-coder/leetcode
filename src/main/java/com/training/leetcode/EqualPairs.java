package com.training.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EqualPairs {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> rows = new HashMap();


        int n = grid.length, ans = 0;

        for(int[] row : grid){
            String rowString = Arrays.toString(row);
            rows.put(rowString, rows.getOrDefault(rowString, 0) + 1);
        }
        for(int r = 0; r < n; r++){
            int[] col = new int[n];
            for(int c = 0; c < n; c++){
                col[c] = grid[c][r];
            }
            String colString = Arrays.toString(col);
            ans += rows.getOrDefault(colString, 0);

        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] grid1 = new int[][]{{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        System.out.println(new EqualPairs().equalPairs(grid1));
    }
}
