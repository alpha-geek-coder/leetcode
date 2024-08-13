package com.training.leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BalanceSplitString {
    public int balancedStringSplit(String s) {
        int ans = 0, left = 0, right = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'L'){
                left++;
            } else {
                right++;
            }
            if(left == right) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new BalanceSplitString().balancedStringSplit("RLRRLLRLRL"));
        System.out.println(new BalanceSplitString().balancedStringSplit("RLRRRLLRLL"));
        System.out.println(new BalanceSplitString().balancedStringSplit("LLLLRRRR"));

        int[][] grid = {{3,8,1,9},{19,7,2,5},{4,6,11,10},{12,0,21,13}}; int k = 4;
        int m = grid.length, n = grid[0].length;
        int[] lastCol = new int[m];
        for(int i = 0; i < k; i++){
            for(int r = 0; r < m; r++){
                lastCol[r] = grid[r][n - 1];
            }

            for(int c = n - 2; c > 1 ; c--){
                for(int r = 0; r < m; r++){
                    grid[r][c + 1] = grid[r][c];
                }
            }

            for(int r = 0; r < m - 1; r++){
                grid[r + 1][0] = lastCol[r];
            }
            grid[0][0] = lastCol[m - 1];
        }
        List<List<Integer>> ans = new ArrayList();
        for(int[] row : grid){
            ans.add(Arrays.stream(row).boxed().collect(Collectors.toList()));
        }

        System.out.println(ans);
    }
}
