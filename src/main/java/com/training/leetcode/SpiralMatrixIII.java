package com.training.leetcode;

public class SpiralMatrixIII {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

        int[][] ans = new int[rows * cols][2];
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int idx = 0;
        for (int step = 1, direction = 0; idx < rows * cols; step++) {
            // Since step increases after moving steps in 2 consecutive directions/ direction pair
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < step; j++) {
                    if(rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols){
                        ans[idx][0] = rStart;
                        ans[idx++][1] = cStart;
                    }
                    rStart += dir[direction][0];
                    cStart += dir[direction][1];
                }
                direction = (direction + 1) % 4;
            }
        }
        return ans;
    }
}
